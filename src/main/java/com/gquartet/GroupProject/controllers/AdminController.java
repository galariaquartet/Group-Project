/*
 * Created on 23/05/2020 at 14:07:40 GMT+2
 */
package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/adminMain")
    public String adminMain(HttpSession session, ModelMap mm) {
        if (((Customer) session.getAttribute("customer")).getRoleId().getRoleId() == 1) {
            return "adminMain";
        }
        return "index";

    }

}
