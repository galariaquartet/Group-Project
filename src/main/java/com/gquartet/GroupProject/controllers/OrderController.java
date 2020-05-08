package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ShippingInfoCustomerInfoPaymentDTO;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.models.OrderStatus;
import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.models.ShippingInformation;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import com.gquartet.GroupProject.services.CustomerOrderService;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.OrderStatusService;
import com.gquartet.GroupProject.services.PaymentService;
import com.gquartet.GroupProject.services.ShippingInformationService;
import com.gquartet.GroupProject.services.ShoppingCartService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ShippingInformationService shippingInformationService;
    @Autowired
    private CustomerInformationSercvice customerInformationSercvice;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping
    public String showOrderForm(Model mm) {
        ShippingInfoCustomerInfoPaymentDTO sicipDTO = new ShippingInfoCustomerInfoPaymentDTO();
        mm.addAttribute("sicipDTO", sicipDTO);
        return "orderForm";
    }

    @RequestMapping("/process")
    public String saveOrderInformation(HttpSession session, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {

        CustomerOrder customerOrder = new CustomerOrder();

        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        customerOrder.setCustomerId(customerService.getCustomer(customerId));
        //  customerOrder.setOrderDate("2020-04-04");
        OrderStatus orderStatus = new OrderStatus();
        Date date = new Date();
        customerOrder.setOrderDate(date);
        customerOrder.setOrderStatusId(orderStatusService.getOrderStatus(2)); //8elei ftia3imo
        customerOrderService.save(customerOrder);
        int ordernumber = customerOrder.getOrderNumber();
        System.out.println("ddddddddddddddddddddd" + ordernumber);

        return "forward:/order/payment/"+ ordernumber;
    }

    @RequestMapping("/payment/{ordernumber}")
    public String savePaymentInformation(@PathVariable("ordernumber") CustomerOrder customerOrder, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {
          System.out.println("%%%%%%%%%%%^%^^^^^^^^^^^^^^^" + customerOrder.getCustomerId() + "GGGGGGGGGGGGGG" + customerOrder.getOrderNumber());
        System.out.println("#$#$$$$$$$$$$$$$$$$$$$$$$$" + info.getPayment());
        int ordernumber = customerOrder.getOrderNumber();
        Payment payment = new Payment();
        int paymentId = payment.getPaymentId();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&"+paymentId);
        return "forward:/order/shippingInfo/"+ ordernumber+"/"+paymentId;
    }

    @RequestMapping("/payment/{ordernumber}/{paymentId}")
    public void saveOrderInformation(@PathVariable("ordernumber") CustomerOrder customerOrder,@PathVariable("paymentId") Payment payment,@ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&SHIPPING " + customerOrder.getCustomerId()+" "+ payment.getPaymentId());
      //  ShippingInformation si = new ShippingInformation();
//prepei na balw to orderdetails id
        System.out.println("#$#$$$$$$$$$$$$$$$$$$$$$$$" + info.getPayment());
        if (info.isCheck() == true) {//ean to checkbox einai check tote to shipping info 8a parei tis nees times
            
            shippingInformationService.newShippingInfoFromShippingInfo(info.getShippingInformation());
            // System.out.println( si.getRecipientFirstName());
        } else {
            shippingInformationService.newShippingInfoFromCustomerInfo(info.getCustomerInformation());
        }
       // return "forward:/order/payment";
    }

    @ModelAttribute("customerInformation")
    public CustomerInformation getcustomerInformation(HttpSession session, ModelMap mm) {
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        return customerInformationSercvice.getCustomerInformation(customerId);
    }

    @ModelAttribute("payments")
    public List<Payment> getPayments(ModelMap mm) {
        return paymentService.listAll();
    }

    @ModelAttribute("check")
    public boolean getValueToCheckbox(ModelMap mm) {
        return false;
    }

}
