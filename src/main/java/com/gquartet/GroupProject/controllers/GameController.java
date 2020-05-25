package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.services.ChatService;
import com.gquartet.GroupProject.services.CustomerService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChatService chatService;

    @RequestMapping("/preGame")
    public String preGame(HttpSession session, ModelMap mm) {
        
        //kalei th lista me ta mnm k ta bazei sto chat opws epishs e to input tou customer pou einai krufo
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        mm.addAttribute("usernameCustomer", customerService.getCustomer(customerId).getUsername());
        mm.addAttribute("messages", chatService.listAll());
        return "game";
    }

}
