
package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.OrderDetailsDTO;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.services.OrderDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderDetailsController {
    
    @Autowired
    OrderDetailsService orderDetailsService;
    
    @RequestMapping("orderdetails/{ordernumber}")
    public String orderDetails(@PathVariable("ordernumber") CustomerOrder customerOrder, ModelMap mm){
        List<OrderDetails> orderDetails = orderDetailsService.getOrderDetails(customerOrder);
      //  List<OrderDetailsDTO> orderDetails = orderDetailsService.getOrderDetails(customerOrder);
        mm.addAttribute("order_details", orderDetails);
        int ordernumber = customerOrder.getOrderNumber();
        System.out.println("############**orderdetails*********************************");
        return "forward:/shippingInformation/"+ordernumber;
      //  return "orderDetailsView";
    }
    
}
