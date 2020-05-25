package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.services.CustomerCreditCardService;
import com.gquartet.GroupProject.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerCreditCardController {

    @Autowired
    private CustomerCreditCardService customerCreditCardService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customerCreditCardView")
    public String viewCustomerCreditCard(ModelMap mm) {
        List<CustomerCreditCard> list = customerCreditCardService.listAll();
        mm.addAttribute("listCustomerCreditCard", list);

        return "customerCreditCardView";
    }

    @RequestMapping("/newCustomerCreditCard/{customerId}")
    public String viewNewCustomerCreditCardForm(@PathVariable("customerId") int customerId, ModelMap mm) {
        CustomerCreditCard customerCreditCard = new CustomerCreditCard();
        mm.addAttribute("customerCreditCard", customerCreditCard);
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
        return "newCustomerCreditCard";
    }

    @RequestMapping("/saveCustomerCreditCard/{customerId}")
    public String saveCustomerCreditCard(@PathVariable("customerId") int customerId, ModelMap mm, @ModelAttribute("customerCreditCard") CustomerCreditCard customerCreditCard) {
        customerCreditCard.setCustomerId(customerService.getCustomer(customerId));
        customerCreditCardService.save(customerCreditCard);
        return "redirect:/customerCreditCardView";
    }

    //gia na ftia3oume to update arxika phgainoume sthn forma 
    @RequestMapping("/editCustomerCreditCard/{customerId}")
    public String showEditCustomerCreditCardForm(@PathVariable("customerId") int customerId, ModelMap mm) {
        mm.addAttribute("customerCreditCard", customerCreditCardService.findCustomerCreditCardByCustomerId(customerId));
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
        return "updateFormCustomerCreditCardView";
    }

    @RequestMapping("/updateCustomerCreditCard/{customerId}")
    public String saveUpdatedCustomerCreditCard(@PathVariable("customerId") int customerId, ModelMap mm, @ModelAttribute("customerCreditCard") CustomerCreditCard customerCreditCard) {
        customerCreditCard.setCustomerId(customerService.getCustomer(customerId));
        customerCreditCardService.update(customerCreditCard);
        return "redirect:/customerCreditCardView";
    }

    @RequestMapping("/deleteCustomerCreditCard/{cardId}")
    public String deleteCustomerCreditCard(@PathVariable int cardId, ModelMap mm) {
        customerCreditCardService.delete(cardId);
        return "redirect:/customerCreditCardView";
    }

}
