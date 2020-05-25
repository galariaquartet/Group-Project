package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.services.CustomerOrderService;
import com.gquartet.GroupProject.services.CustomerService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerOrderService customerOrderService;

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
        int tempCustomerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        Customer customer = customerService.getCustomer(tempCustomerId);
        mm.addAttribute("customer", customer);

        if (customerOrderService.findCustomerOrderByCustomerId(tempCustomerId).size() > 0) {
            CustomerOrder customerLastOrder = customerOrderService.findCustomerOrderByCustomerId(tempCustomerId).get(0);
            mm.addAttribute("customerLastOrder", customerLastOrder);
            mm.addAttribute("listCustomerOrder", customerOrderService.findCustomerOrderByCustomerId(tempCustomerId));
            return "account";
        }

        return "account";
    }

}
