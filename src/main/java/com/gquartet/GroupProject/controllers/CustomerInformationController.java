
package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerInformationController {
       
    @Autowired 
    CustomerInformationSercvice customerInformationSercvice;
    
     //***************edw kanloume oti exei na kanei me ton customer information*********************
   //TODO MONO TO SUGKEKRIMENO TO SUGKEKRIMENO ID
    @RequestMapping("/customerInformation/{id}")
    public String viewCustomerInformationPage(ModelMap mm) {
        List<CustomerInformation> list = customerInformationSercvice.listAll();
        mm.addAttribute("listCustomerInformations", list);
        return "customerInformationView";
    }
//
//    @RequestMapping("/newCustomerInformation/{customerId}")
//    public String viewNewCustomerInformationForm(@PathVariable("customerId") int customerId, ModelMap mm) {
//        CustomerInformation customerInformation = new CustomerInformation();
//        mm.addAttribute("customerInformation", customerInformationSercvice.getCustomerInformation(customerId));
//        return "newFormCustomerInformation";
//    }
//
//    @RequestMapping("/saveCustomerInformation")
//    public String saveCustomerInformation(ModelMap mm, @ModelAttribute("customerInformation") CustomerInformation customerInformation) {
//        customerInformationSercvice.save(customerInformation);
//        return "redirect:/customerInformation";
//    }

    @RequestMapping("/editCustomerInformation/{customerId}")
    public String showEditCustomerInformationForm(@PathVariable("customerId") int customerId, ModelMap mm) {
        mm.addAttribute("customerInformation", customerInformationSercvice.getCustomerInformation(customerId));
        return "updateFormCustomerInformation";
    }

    @RequestMapping("/updateCustomerInformation")
    public String saveUpdatedCustomerInformation(ModelMap mm, @ModelAttribute("customerInformation") CustomerInformation customerInformation) {
        customerInformationSercvice.update(customerInformation);
        return "redirect:/customerInformation";
    }

    //TODO na ftixnoume na sbhnontai ta MONO TA stoixeia 
    @RequestMapping("/deleteCustomerInformation/{customerId}")
    public String deleteProduct(@PathVariable int customerId, ModelMap mm) {
        customerInformationSercvice.delete(customerId);
        return "redirect:/customerInformation";
    } 
    
    
}