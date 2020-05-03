package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerInformationController {

    @Autowired
    CustomerInformationSercvice customerInformationSercvice;

    //***************edw kanloume oti exei na kanei me ton customer information*********************
    //TODO MONO TO SUGKEKRIMENO TO SUGKEKRIMENO ID
    @RequestMapping("/customerInformation")
    public String viewCustomerInformationPage(HttpSession session, ModelMap mm) {
        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerid = ((Customer) session.getAttribute("customer")).getCustomerId();

            mm.addAttribute("customerInformations", customerInformationSercvice.getCustomerInformation(customerid)); // me auton to tropo pairnoume too id tou customer
            return "customerInformationView";
        }
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

    // @RequestMapping(value = "/editCustomerInformation", method = RequestMethod.GET)
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
            return "redirect:/customerInformation";
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
            return "redirect:/customerInformation";
        }
    }

}
