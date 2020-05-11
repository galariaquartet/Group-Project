package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ShippingInfoCustomerInfoPaymentDTO;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.models.OrderStatus;
import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ShippingInformation;
import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import com.gquartet.GroupProject.services.CustomerOrderService;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.OrderDetailsService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping
    public String showOrderForm(Model mm) {
        ShippingInfoCustomerInfoPaymentDTO sicipDTO = new ShippingInfoCustomerInfoPaymentDTO();
        mm.addAttribute("sicipDTO", sicipDTO);
        return "orderForm";
    }

    @RequestMapping("/process")
    public String saveOrderInformation(HttpSession session, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {

        //dhmiourgeitai h order k apo8hkeyetai k to order status
        CustomerOrder customerOrder = new CustomerOrder();
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        customerOrder.setCustomerId(customerService.getCustomer(customerId));

        OrderStatus orderStatus = new OrderStatus();
        Date date = new Date();
        customerOrder.setOrderDate(date);
        customerOrder.setOrderStatusId(orderStatusService.getOrderStatus(1)); //to order status san default timh pairnei thn proetoimasia paraggelias 
        customerOrderService.save(customerOrder);

        int ordernumber = customerOrder.getOrderNumber();

        return "forward:/order/shippingInfo/" + ordernumber;
    }

    //APOUHKEUETAI TO SHIPPING INFORMATION ANALOGA ME TO POU UELEI NA TH STEILEI O XRHSTHS THS PARAGGELIAS
    @RequestMapping("/shippingInfo/{ordernumber}")
    public String saveOrderInformation(@PathVariable("ordernumber") CustomerOrder customerOrder, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {

        ShippingInformation si = new ShippingInformation();
        int ordernumber = customerOrder.getOrderNumber();

        //ean to checkbox den einai check tote to shipping info 8a parei tis nees times 
        if (info.isCheck() != true) {
            si = shippingInformationService.newShippingInfoFromShippingInfo(info.getShippingInformation());            // System.out.println( si.getRecipientFirstName());
            int shippinInfoId = si.getShippingInformationId();
            return "forward:/order/finishOrder/" + ordernumber + "/" + shippinInfoId;
        }

        si = shippingInformationService.newShippingInfoFromCustomerInfo(info.getCustomerInformation());
        int shippinInfoId = si.getShippingInformationId();

        return "forward:/order/finishOrder/" + ordernumber + "/" + shippinInfoId;
    }

    @RequestMapping("/finishOrder/{ordernumber}/{shippinInfoId}")
    public String finishOrder(@PathVariable("ordernumber") CustomerOrder customerOrder, HttpSession session, @PathVariable("shippinInfoId") ShippingInformation shippingInformation, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {

        Payment payment = info.getPayment();
        int paymentId = payment.getPaymentId();

        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        
        List<ShoppingCart> listProduct = shoppingCartService.getShoppingCartByCustomerId(customerId);
        for (int i = 0; i < listProduct.size(); i++) {
            Product pr = listProduct.get(i).getProductId();

            //dhmiourgeitai to order detail 
            OrderDetails orderDetails = new OrderDetails(null, customerOrder, pr, payment, shippingInformation);
            orderDetailsService.saveOrderDetails(orderDetails);
            //ME TO POU MPOUN TSH BASH META SBHNOUME APO TH BASH TO KALOA8I TOU SUGKEKRIMENOU XRHSTH
            ShoppingCart sc = shoppingCartService.getCartByProduct(pr.getProductId(), customerId);
            shoppingCartService.delete(sc.getShoppingCartId());
        }
        return "redirect:/customerOrder"; //odhgei ton xrhsth pali sthn selida orderdetails mesw tou customerOrderController
    }


    @RequestMapping("/card")
    public String showPopUpcardInformation(Model mm) {

        CustomerCreditCard customerCreditCard = new CustomerCreditCard();
        mm.addAttribute("customerCreditCard", customerCreditCard);

        return "forward:/order/cardInfo";
    }

    @RequestMapping("/cardInfo")
    public String cardInformation(Model mm) {

        System.out.println("#################################");
        return "redirect:/order";
    }


    @ModelAttribute("payments")
    public List<Payment> getPayments(ModelMap mm) {
        return paymentService.listAll();
    }

    @ModelAttribute("check")
    public boolean getValueToCheckbox(ModelMap mm) {
        return false;
    }

    @ModelAttribute("customerCreditCard")
    public CustomerCreditCard customerCreditCard(ModelMap mm) {
        CustomerCreditCard customerCreditCard = new CustomerCreditCard();
        return customerCreditCard;
    }

    @ModelAttribute("customerInformation")
    public CustomerInformation customerInformation(HttpSession session, ModelMap mm) {
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        CustomerInformation customerInformation = customerInformationSercvice.getCustomerInformation(customerId);
        return customerInformation;
    }


}
