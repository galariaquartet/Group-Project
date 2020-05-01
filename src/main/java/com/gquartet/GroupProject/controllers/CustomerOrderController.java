package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.services.CustomerOrderService;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.OrderStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping("{customerId}/customerOrder")
    public String viewCustomerOrder(@PathVariable("customerId") int customerId, ModelMap mm) {
        List<CustomerOrder> list = customerOrderService.listAll();
        mm.addAttribute("listCustomerOrder", list);
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
        return "customerOrderView";
    }

    @RequestMapping("/{customerId}/newCustomerOrder")
    public String viewNewCustomerOrderForm(@PathVariable("customerId") int customerId, ModelMap mm) {
        CustomerOrder customerOrder = new CustomerOrder();
        mm.addAttribute("customerOrder", customerOrder);
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());

        return "newCustomerOrder";
    }

    @RequestMapping("/{customerId}/saveCustomerOrder")
    public String saveCustomerOrder(@PathVariable("customerId") int customerId, ModelMap mm, @ModelAttribute("customerOrder") CustomerOrder customerOrder) {
       
        customerOrder.setOrderStatusId(orderStatusService.getOrderStatus(2)); //pros to paron to bazw xeirokinhta prepei na ftiaxte
        customerOrder.setCustomerId(customerService.getCustomer(customerId));
        customerOrderService.save(customerOrder);
        return "redirect:/{customerId}/customerOrder";
    }

    @RequestMapping("/{customerId}/editCustomerOrder/{orderNumber}")
    public String showEditProductForm(@PathVariable("customerId") int customerId, @PathVariable("orderNumber") int orderNumber, ModelMap mm) {
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
        mm.addAttribute("customerOrder", customerOrderService.getCustomerOrder(orderNumber));
        return "updateFormCustomerOrder";
    }

    @RequestMapping("/{customerId}/updateCustomerOrder")
    public String saveUpdatedCustomerOrder(@PathVariable("customerId") int customerId, ModelMap mm, @ModelAttribute("customerOrder") CustomerOrder customerOrder) {
                customerOrder.setOrderStatusId(orderStatusService.getOrderStatus(2)); //pros to paron to bazw xeirokinhta prepei na ftiaxte
        customerOrder.setCustomerId(customerService.getCustomer(customerId));
        customerOrderService.update(customerOrder);
        return "redirect:/{customerId}/customerOrder";
    }

//    @RequestMapping("/deleteCustomerInformation/{orderNumber}")
//    public String deleteCustomerOrder(@PathVariable int orderNumber, ModelMap mm) {
//        customerOrderService.delete(orderNumber);
//        return "redirect:/customerOrder";
//    }

}
