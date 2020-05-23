package com.gquartet.GroupProject.controllers;

import org.springframework.stereotype.Controller;
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
    public String account() {
        return "account";
    }

}
