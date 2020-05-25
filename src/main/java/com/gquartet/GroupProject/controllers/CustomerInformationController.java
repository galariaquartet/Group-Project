package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerInformationController {

    @Autowired
    CustomerInformationSercvice customerInformationSercvice;
    
    @RequestMapping(value = "/editCustomerInformation")
    public String showEditCustomerInformationForm(HttpSession session, ModelMap mm) {
        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {

            int customerid = ((Customer) session.getAttribute("customer")).getCustomerId();
            mm.addAttribute("customerInformation", customerInformationSercvice.getCustomerInformation(customerid));
            return "updateFormCustomerInformation";
        }
    }

    @RequestMapping("/updateCustomerInformation")
    public String saveUpdatedCustomerInformation(HttpSession session, ModelMap mm, @ModelAttribute("customerInformation") CustomerInformation customerInformation) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            customerInformationSercvice.update(customerInformation);
            return "redirect:/account";
        }
    }

    @RequestMapping("/deleteCustomerInformation")
    public String deleteProduct(HttpSession session, ModelMap mm) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerid = ((Customer) session.getAttribute("customer")).getCustomerId();

            CustomerInformation customerInformation = customerInformationSercvice.getCustomerInformation(customerid);
            customerInformation.setFirstName(null);
            customerInformation.setLastName(null);
            customerInformation.setPhone(null);
            customerInformation.setState(null);
            customerInformation.setCity(null);
            customerInformation.setStreet(null);
            customerInformation.setZip(null);

            customerInformationSercvice.update(customerInformation);
            return "redirect:/account";
        }
    }

}
