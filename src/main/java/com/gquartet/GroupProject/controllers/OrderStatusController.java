package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.OrderStatus;
import com.gquartet.GroupProject.services.OrderStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping("/orderStatus")
    public String viewOrderStatus(ModelMap mm) {
        List<OrderStatus> list = orderStatusService.listAll();
        mm.addAttribute("orderStatusList", list);
        return "orderStatusView";
    }

    @RequestMapping("/newOrderStatus")
    public String viewNewProductForm(ModelMap mm) {
        OrderStatus orderStatus = new OrderStatus();
        mm.addAttribute("orderStatus", orderStatus);
        return "newOrderStatus";
    }

    @RequestMapping("/saveOrderStatus")
    public String saveProduct(ModelMap mm, @ModelAttribute("orderStatus") OrderStatus orderStatus) {
        orderStatusService.save(orderStatus);
        return "redirect:/orderStatus";
    }

    @RequestMapping("/editOrderStatus/{orderStatusId}")
    public String showEditOrderStatusForm(@PathVariable("orderStatusId") int orderStatusId, ModelMap mm) {
        mm.addAttribute("orderStatus", orderStatusService.getOrderStatus(orderStatusId));
        return "updateFormOrderStatus";
    }

    @RequestMapping("/updateOrderStatus")
    public String saveUpdatedOrderStatus(ModelMap mm, @ModelAttribute("orderStatus") OrderStatus orderStatus) {
        orderStatusService.update(orderStatus);
        return "redirect:/orderStatus";
    }

    @RequestMapping("/deleteOrderStatus/{orderStatusId}")
    public String deleteorderStatus(@PathVariable int orderStatusId, ModelMap mm) {
        orderStatusService.delete(orderStatusId);
        return "redirect:/orderStatus";
    }

}
