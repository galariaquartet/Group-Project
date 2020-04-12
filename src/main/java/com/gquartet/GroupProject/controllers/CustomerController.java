/*
 * Created on 12/04/2020 at 22:12:45 GMT+2
 */
package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.RegisterCustomerDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.Role;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.RoleService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/preregister")
    public String preRegister(ModelMap mm) {
        RegisterCustomerDto registerUserDto = new RegisterCustomerDto();
        mm.addAttribute("registeruser", registerUserDto);
        return "register"; //register.jsp
    }

    @PostMapping("/doregister")
    public String doRegister(@ModelAttribute("registeruser") RegisterCustomerDto dto) {
        Customer c = new Customer();

        //TODO Check if username already exists
        c.setUsername(dto.getUsername());
        //TODO check if email already exists
        c.setEmail(dto.getEmail());
        //TODO Check 2 passwords
        c.setPassword(passwordEncoder.encode(dto.getPassword()));
        Role role = roleService.getCustomerRole();
        c.setRoleId(role);
        customerService.saveCustomer(c);
        return "redirect:/"; // Με αυτήν την εντολή θα ανοίξει την index
    }

    @PostMapping("/dologin")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password,
            ModelMap mm,
            HttpSession session) {
        Customer tempcustomer = customerService.getCustomerByUsername(username);
        if (tempcustomer == null) {// wrong username
            mm.addAttribute("wrongusername", "wrong username");
            return "index";
        } else {
            // checks the plain-text password with .matches, since database's password is hashed.
            if (!passwordEncoder.matches(password, tempcustomer.getPassword())) {//wrong pass
                mm.addAttribute("wrongpassword", "wrong password");
                return "index";
            }
        }
        // Login ok
        // Kathe fora pou o xrhsths exei kanei log in, prepei na ton valoume
        // sto session, wste na gnwrizoume ana pasa stigmh poioi xrhstes einai sundedemenoi.
        session.setAttribute("customer", tempcustomer);

        // Prepei na doume an einai aplos xrhsths/customer h an einai admin
        if (tempcustomer.getRoleId().getRoleId() == 1) { // Admin
            mm.addAttribute("welcomeadmin", "welcome admin");
            return "adminindex";
        }
        if (tempcustomer.getRoleId().getRoleId() == 2) { // User/Customer
            mm.addAttribute("welcomecustomer", "welcome customer");
            return "index";
        }
        return "problem";
    }
}
