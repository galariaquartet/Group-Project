package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.services.CustomerOrderService;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.OrderStatusService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping("/customerOrder")
    public String viewCustomerOrder(HttpSession session, ModelMap mm) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerid = ((Customer) session.getAttribute("customer")).getCustomerId();
            if (customerOrderService.findCustomerOrderByCustomerId(customerid).size() > 0) {
                CustomerOrder customerLastOrder = customerOrderService.findCustomerOrderByCustomerId(customerid).get(0);
                mm.addAttribute("customerLastOrder", customerLastOrder);
                mm.addAttribute("listCustomerOrder", customerOrderService.findCustomerOrderByCustomerId(customerid));
                return "forward:/account";
            }
            return "forward:/account";
        }
    }
}
