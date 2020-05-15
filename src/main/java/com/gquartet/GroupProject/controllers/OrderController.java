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
import com.gquartet.GroupProject.services.CustomerCreditCardService;
import com.gquartet.GroupProject.services.CustomerInformationSercvice;
import com.gquartet.GroupProject.services.CustomerOrderService;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.OrderDetailsService;
import com.gquartet.GroupProject.services.OrderStatusService;
import com.gquartet.GroupProject.services.PaymentService;
import com.gquartet.GroupProject.services.ShippingInformationService;
import com.gquartet.GroupProject.services.ShoppingCartService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
//@RequestMapping("/order")
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
    @Autowired
    private CustomerCreditCardService customerCreditCardService;

    @RequestMapping("/order/{checkedproducts}")
    public String showOrderForm(HttpSession session, Model mm, @PathVariable("checkedproducts") String checkedproducts) {
        System.out.println("################################## checkedproducts" + checkedproducts);
        // Start: Getting and Passing the ShoppingCart ids from the checked products
        String[] temp = checkedproducts.split(",");
        List<Integer> customerProducts = new ArrayList();
        for (int i = 0; i < temp.length; i++) {
            customerProducts.add(Integer.parseInt(temp[i].trim()));
        }
        mm.addAttribute("customerProducts", customerProducts);
        // End
        ShippingInfoCustomerInfoPaymentDTO sicipDTO = new ShippingInfoCustomerInfoPaymentDTO();
        mm.addAttribute("sicipDTO", sicipDTO);

//        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
//        CustomerCreditCard customerCreditCard = customerCreditCardService.findCustomerCreditCardByCustomerId(customerId);
//        mm.addAttribute("customerCreditCard1", customerCreditCard);
        return "orderForm";
    }

    @RequestMapping("/process/{checkedproducts}")
    public String saveOrderInformation(HttpSession session, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info, @PathVariable("checkedproducts") String checkedproducts) {
        System.out.println("**************ORDER NUMBER******************************");
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

        //  return "forward:/order/shippingInfo/" + ordernumber;
        return "forward:/shippingInfo/" + checkedproducts + "/" + ordernumber;
    }

    //APOUHKEUETAI TO SHIPPING INFORMATION ANALOGA ME TO POU UELEI NA TH STEILEI O XRHSTHS THS PARAGGELIAS
    @RequestMapping("/shippingInfo/{checkedproducts}/{ordernumber}")
    public String saveOrderInformation(HttpSession session, @PathVariable("ordernumber") CustomerOrder customerOrder, @PathVariable("checkedproducts") String checkedproducts, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {
        ShippingInformation si = new ShippingInformation();
        int ordernumber = customerOrder.getOrderNumber();
        System.out.println("**************shipping Info******************************");
        //ean to checkbox den einai check tote to shipping info 8a parei tis nees times 
        if (info.isCheck() != true) {
            si = shippingInformationService.newShippingInfoFromShippingInfo(info.getShippingInformation());            // System.out.println( si.getRecipientFirstName());
            int shippinInfoId = si.getShippingInformationId();
            return "forward:/finishOrder/" + checkedproducts + "/" + ordernumber + "/" + shippinInfoId;
        }
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        CustomerInformation customerInformation = customerInformationSercvice.getCustomerInformation(customerId);
        si = shippingInformationService.newShippingInfoFromCustomerInfo(customerInformation);
        int shippinInfoId = si.getShippingInformationId();

        // return "forward:/order/finishOrder/" + ordernumber + "/" + shippinInfoId;
        return "forward:/finishOrder/" + checkedproducts + "/" + ordernumber + "/" + shippinInfoId;
    }

    @RequestMapping("/finishOrder/{checkedproducts}/{ordernumber}/{shippinInfoId}")
    public String finishOrder(@PathVariable("ordernumber") CustomerOrder customerOrder, HttpSession session, @PathVariable("checkedproducts") String checkedproducts, @PathVariable("shippinInfoId") ShippingInformation shippingInformation, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {

        Payment payment = info.getPayment();
        int paymentId = payment.getPaymentId();
        System.out.println("**************FINISHED ORDER******************************");

        // Start: Getting and Passing the ShoppingCart ids from the checked products
        String[] temp = checkedproducts.split(",");
        List<Integer> customerProducts = new ArrayList();
        for (int i = 0; i < temp.length; i++) {
            customerProducts.add(Integer.parseInt(temp[i])); //metatrepoume tis string times se int k me auton ton tropo dhmiourgoume mia lista me ta shopping cart ids
        }

        for (int i = 0; i < customerProducts.size(); i++) {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&***************" + customerProducts.get(i));
            int shoppingCartId = customerProducts.get(i);
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&***************" + shoppingCartId);

            ShoppingCart shoppingCart = shoppingCartService.getCart(shoppingCartId); //briskoume to shopping cart mesa apo to service me bash to shoppingCartId

            Product productId = shoppingCart.getProductId(); //pairnoume apo shoppingCart to productId 
//
//            //dhmiourgeitai to order detail 
//            OrderDetails orderDetails = new OrderDetails(null, customerOrder, productId, payment, shippingInformation);
//            orderDetailsService.saveOrderDetails(orderDetails);
//            //ME TO POU MPOUN TSH BASH META SBHNOUME APO TH BASH TO KALOA8I TOU SUGKEKRIMENOU XRHSTH
//          //  ShoppingCart sc = shoppingCartService.getCartByProduct(pr.getProductId(), customerId);
//            shoppingCartService.delete(shoppingCart.getShoppingCartId());
        }

        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        List<ShoppingCart> listProduct = shoppingCartService.getShoppingCartByCustomerId(customerId);

        for (int i = 0; i < listProduct.size(); i++) {
            Product pr = listProduct.get(i).getProductId();

            int quantity = 1;
            BigDecimal totalPrice = BigDecimal.valueOf(2);

            //dhmiourgeitai to order detail 
            //  OrderDetails orderDetails = new OrderDetails(null, quantity,totalPrice,customerOrder, payment, pr, shippingInformation);
            //  orderDetailsService.saveOrderDetails(orderDetails);
            //ME TO POU MPOUN TSH BASH META SBHNOUME APO TH BASH TO KALOA8I TOU SUGKEKRIMENOU XRHSTH
            ShoppingCart sc = shoppingCartService.getCartByProduct(pr.getProductId(), customerId);
            shoppingCartService.delete(sc.getShoppingCartId());
        }
        return "redirect:/customerOrder"; //odhgei ton xrhsth pali sthn selida orderdetails mesw tou customerOrderController
    }

    //einai otan eisagei o kainourgia stoixeia ths kartas edw apo8hkeuontai 
    @RequestMapping("/card/{checkedproducts}")
    public String showPopUpcardInformation(Model mm, @PathVariable String checkedproducts) {

        CustomerCreditCard customerCreditCard = new CustomerCreditCard();
        mm.addAttribute("customerCreditCard", customerCreditCard);

        return "forward:/cardInfo/" + checkedproducts;
    }

    //apo8hkeuontai ta stoixeia ths kartas k epistrefei pali pisw sthn selida 
    @RequestMapping("/cardInfo/{checkedproducts}")
    public String cardInformation(Model mm, @PathVariable String checkedproducts) {

        return "forward:/order/" + checkedproducts;
    }

    //otan kanei allages sta stoixeia tou customer Information apo8hkeuontai k sth bash
    @RequestMapping("/saveChangesToCustomerInfo/{checkedproducts}")
    public String saveChangesToCustomerInfo(HttpSession session, @ModelAttribute("customerInformation") CustomerInformation info, @PathVariable String checkedproducts) {
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        customerInformationSercvice.update(info);
        return "forward:/order/" + checkedproducts;
    }

    @ModelAttribute("payments")
    public List<Payment> getPayments(ModelMap mm) {
        return paymentService.listAll();
    }

    @ModelAttribute("check")
    public boolean getValueToCheckbox(ModelMap mm) {
        return false;
    }

    @ModelAttribute("customerCreditCardSavedDataFromDB")
    public CustomerCreditCard customerCreditCard(HttpSession session, ModelMap mm) {
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        CustomerCreditCard customerCreditCard = customerCreditCardService.findCustomerCreditCardByCustomerId(customerId);
        return customerCreditCard;
    }

    //otan kanei allages sta stoixeia tou customer Information apo8hkeuontai k sth bash
    //  @RequestMapping("/updateCustomerCreditCard/{checkedproducts}")
    @RequestMapping("/updateCustomerCreditCard/{checkedproducts}")
    public String updateCustomerCreditCard(HttpSession session, @ModelAttribute("customerCreditCardSavedDataFromDB") CustomerCreditCard customerCreditCard, @PathVariable String checkedproducts) {
        CustomerCreditCard c = new CustomerCreditCard();
        c.setCardId(customerCreditCard.getCardId());
        System.out.println("customerCreditCard.getCardId()" + customerCreditCard.getCardId());
        c.setOwnerFirstName(customerCreditCard.getOwnerFirstName());
        System.out.println("customerCreditCard.getOwnerFirstName()" + customerCreditCard.getOwnerFirstName());
        c.setOwnerLastName(customerCreditCard.getOwnerLastName());
        System.out.println("customerCreditCard.getOwnerLastName()" + customerCreditCard.getOwnerLastName());
        c.setCardNumber(customerCreditCard.getCardNumber());
        System.out.println("customerCreditCard.getCardNumber()" + customerCreditCard.getCardNumber());
        c.setCardNumberLastDigits(customerCreditCard.getCardNumberLastDigits());
        System.out.println("customerCreditCard.getCardNumberLastDigits()" + customerCreditCard.getCardNumberLastDigits());
        c.setCvv(customerCreditCard.getCvv());
        System.out.println("customerCreditCard.getCvv()" + customerCreditCard.getCvv());
        c.setExpirationDate(customerCreditCard.getExpirationDate());
        System.out.println("customerCreditCard.getExpirationDate()" + customerCreditCard.getExpirationDate());
        c.setCustomerId(customerCreditCard.getCustomerId());
        System.out.println("customerCreditCard.getCustomerId()" + customerCreditCard.getCustomerId());
        // customerCreditCardService.update(c);
        //  customerCreditCardService.update(customerCreditCard);
        return "forward:/order/" + checkedproducts;
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

    @ResponseBody
    @RequestMapping("/checkemail/{firstName}")
    public void checkEmail(@PathVariable("firstName") String firstName, String lastName) {
        System.out.println(firstName);

    }
}
