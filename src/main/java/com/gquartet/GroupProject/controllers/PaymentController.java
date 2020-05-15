package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.services.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/payment/{ordernumber}")
    public String viewPaymentPage(@PathVariable("ordernumber") CustomerOrder customerOrder, ModelMap mm) {
        int ordernumber = customerOrder.getOrderNumber();

        List<Payment> list = paymentService.findPaymentListByOrderDetailsId(ordernumber);
        mm.addAttribute("listPayment", list);
        // return "paymentView";
        return "orderDetailsView";
    }

    //edw phgainoume otan 8eloume na praggeiloume oti exoume balei mesa sto kala8i
//    @GetMapping("/payments")
//    public String viewPayment(ModelMap mm) {
//        Payment payment = new Payment();
//        mm.addAttribute("payment",payment);
//        List<Payment> list = paymentService.listAll();
//        mm.addAttribute("listPayment", list);
//       // return "paymentView";
//            return "orderPage";
//    }
    @RequestMapping("/newPayment")
    public String viewNewPaymentForm(ModelMap mm) {
        Payment payment = new Payment();
        mm.addAttribute("payment", payment);
        return "newPayment";
    }

    @RequestMapping("/savePayment")
    public String saveProduct(ModelMap mm, @ModelAttribute("payment") Payment payment) {
        paymentService.save(payment);
        return "redirect:/payment";
    }

    @RequestMapping("/editPayment/{paymentId}")
    public String showEditPaymentForm(@PathVariable("paymentId") int paymentId, ModelMap mm) {
        mm.addAttribute("payment", paymentService.getPayment(paymentId));
        return "updateFormPayment";
    }

    @RequestMapping("/updatePayment")
    public String saveUpdatedPayment(ModelMap mm, @ModelAttribute("payment") Payment payment) {
        paymentService.update(payment);
        return "redirect:/payment";
    }

    @RequestMapping("/deletePayment/{paymentId}")
    public String deletePayment(@PathVariable int paymentId, ModelMap mm) {
        paymentService.delete(paymentId);
        return "redirect:/payment";
    }

}
