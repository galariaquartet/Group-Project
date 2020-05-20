package com.gquartet.GroupProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //TODO na vgainei mhnuma lathous an o xrhsths pathsei localhost:8080/account sthn index
//    @RequestMapping(value = "/account")
//    public String account(HttpSession session, ModelMap mm) {
//        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
//            return "index";
//        } else {
//            mm.addAttribute("test123456", ((Customer) session.getAttribute("customer")).getCustomerId()); // me auton to tropo pairnoume too id tou customer
//            return "account";
//        }
//    }
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
