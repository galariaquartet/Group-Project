package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ShippingInformationPaymentDto;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.models.ShippingInformation;
import com.gquartet.GroupProject.services.PaymentService;
import com.gquartet.GroupProject.services.ShippingInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShippingInformationController {

    @Autowired
    private ShippingInformationService shippingInformationService;
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/shippingInformation/{ordernumber}")
    public String viewHomePage(@PathVariable("ordernumber") CustomerOrder customerOrder,ModelMap mm) {
        
        int ordernumber = customerOrder.getOrderNumber();

        List<ShippingInformation> list = shippingInformationService.findShippingInformation(ordernumber);
        mm.addAttribute("listShippingInformation", list);
        
      
       // return "orderDetailsView";
        return "forward:/payment/"+ordernumber;
    }

//    @RequestMapping("/newShippingInformation")
//    public String viewNewProductForm(ModelMap mm) {
//        ShippingInformation shippingInformation = new ShippingInformation();
//        mm.addAttribute("shippingInformation", shippingInformation);
//        return "newShippingInformation";
//    }
    @RequestMapping("/newShippingInformationPayment")
    public String viewNewProductForm(ModelMap mm) {
        ShippingInformationPaymentDto shippingInformationPaymentDto = new ShippingInformationPaymentDto();
        mm.addAttribute("shippingInformationPaymentDto", shippingInformationPaymentDto);
       List<Payment> paymentList = paymentService.listAll();
        mm.addAttribute("paymentList", paymentList);
 
        return "newShippingInformationPaymentForm";
    }

    @RequestMapping("/saveShippingInformation")
    public String saveShippingInformation(ModelMap mm, @ModelAttribute("shippingInformationPaymentDto") ShippingInformationPaymentDto shippingInformationPaymentDto) {
        shippingInformationPaymentDto.setShippingInformationId(null);
        shippingInformationPaymentDto.setShippingCountry(shippingInformationPaymentDto.getShippingCountry());
        shippingInformationPaymentDto.setShippingState(shippingInformationPaymentDto.getShippingState());        
        shippingInformationPaymentDto.setShippingCity(shippingInformationPaymentDto.getShippingCity());    
        shippingInformationPaymentDto.setShippingStreet(shippingInformationPaymentDto.getShippingStreet());
        shippingInformationPaymentDto.setShippingZip(shippingInformationPaymentDto.getShippingZip());
        shippingInformationPaymentDto.setRecipientFirstName(shippingInformationPaymentDto.getRecipientFirstName());
        
//        shippingInformationService.save(shippingInformation);
        return "redirect:/";
    }
//    @RequestMapping("/saveShippingInformation")
//    public String saveShippingInformation(ModelMap mm, @ModelAttribute("shippingInformation") ShippingInformation shippingInformation) {
//        shippingInformationService.save(shippingInformation);
//        return "redirect:/";
//    }

    @RequestMapping("/editShippingInformation/{shippingInformationId}")
    public String showEditShippingInformationForm(@PathVariable("shippingInformationId") int shippingInformationId, ModelMap mm) {
        mm.addAttribute("shippingInformation", shippingInformationService.getShippingInformation(shippingInformationId));
        return "updateFormShippingInformation";
    }

    @RequestMapping("/updateShippingInformation")
    public String saveUpdatedShippingInformation(ModelMap mm, @ModelAttribute("shippingInformation") ShippingInformation shippingInformation) {
        shippingInformationService.update(shippingInformation);
        return "redirect:/shippingInformation";
    }

    @RequestMapping("/deleteShippingInformation/{shippingInformationId}")
    public String deleteShippingInformation(@PathVariable int shippingInformationId, ModelMap mm) {
        shippingInformationService.delete(shippingInformationId);
        return "redirect:/shippingInformation";
    }

}
