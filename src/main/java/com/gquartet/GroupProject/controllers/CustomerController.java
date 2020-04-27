package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.RegisterCustomerDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.Role;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.RoleService;
import com.gquartet.GroupProject.validators.CustomerValidator;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoleService roleService;

    @Autowired
    CustomerValidator customerValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {//WebDataBinder is a DataBinder that binds request parameter to JavaBean objects.
        binder.addValidators(customerValidator);
    }

    @GetMapping("/preregister")
    public String preRegister(ModelMap mm) {
        RegisterCustomerDto registerUserDto = new RegisterCustomerDto();
        mm.addAttribute("registeruser", registerUserDto);
        return "register"; //register.jsp
    }

    @PostMapping("/doregister")
    public String doRegister(@Valid @ModelAttribute("registeruser") RegisterCustomerDto dto, BindingResult bindingResult, ModelMap mm) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        //na baleis na mhn pairnei xarakthres***********************************************************

        Customer c = new Customer();
        //TODO Check if username already exists   --> check
        c.setUsername(dto.getUsername());
        //TODO check if email already exists    --> check
        c.setEmail(dto.getEmail());
        //TODO Check 2 passwords             --> check
        c.setPassword(passwordEncoder.encode(dto.getPassword())); //kwdikopoioume to password sth bash
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
    
    @ResponseBody
    @GetMapping(value = "checkusername/{name}")
    public String checkUsername(@PathVariable("name") String name){
        Customer customer = new Customer();
        customer = customerService.getCustomerByUsername(name);
        if (customer == null){
            return "ok";
        }
        return "already exists";
    }
    
    @ResponseBody
    @GetMapping(value = "checkemail/{email}")
    public String checkEmail (@PathVariable("email") String email){
        Customer customer = new Customer();
        customer = customerService.getCustomerByEmail(email);
        if (customer == null){
            return "ok";
        }
        return "already exists";
    }
}
