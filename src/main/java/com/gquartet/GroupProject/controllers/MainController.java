package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/account")
    public String account(HttpSession session, ModelMap mm) {
        if (session.getAttribute("customer") == null) { 
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        }
        Customer customer = (Customer) session.getAttribute("customer");
        mm.addAttribute("customer", customer);
        System.out.println(customer);
        return "account";
    }
    
}
