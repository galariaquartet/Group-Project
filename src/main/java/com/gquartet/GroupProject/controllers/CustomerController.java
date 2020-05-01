package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.CustomerDto;
import com.gquartet.GroupProject.dtos.RegisterCustomerDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.models.Role;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.RoleService;
import com.gquartet.GroupProject.validators.CustomerValidator;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
 
    //pairnei to antikeimeno k tou leme oti exei ena validator etsi kolame to controller sto validator
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

//***************************ELEGXW AN TA STOIXEIA POU MOU DINEI O XRHSTHS EINAI SWSTA************************************** 
//me th sunarthsh auth phgainei ston validator k elegxei an ta dedomena einai la8os h oxi 
        if (bindingResult.hasErrors()) {
            return "register"; //3anadeixnei thn index alla pleon me ta errors sthn 8esh pou tous exei upodei3ei o xrhsths
        }

//***************************EAN TA STOIXEIA POU DINEI O XRHSTHS EINAI SWSTA TOTE BAZW TON XRHSTH STH BASH**************************************   
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

    //epistrefei mia lista me to username k to email tou customer se json morfh
//    @ResponseBody
//    @GetMapping("/foo")
//    public List<CustomerDto> allCustomersUsernames() {
//        List<CustomerDto> usernamesEmails = customerService.listUsernameEmail();
//        return usernamesEmails;
//    }
   
    
}
