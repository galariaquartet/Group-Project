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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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


    @RequestMapping("/order/{checkedproducts}/{totalPrice}")
    public String showOrderForm(HttpSession session, Model mm, @PathVariable("checkedproducts") String checkedproducts, @PathVariable("totalPrice") double totalPrice) {
        mm.addAttribute("totalPrice", totalPrice);
        ShippingInfoCustomerInfoPaymentDTO sicipDTO = new ShippingInfoCustomerInfoPaymentDTO();
        mm.addAttribute("totalPrice", totalPrice);
        mm.addAttribute("sicipDTO", sicipDTO);
        return "orderForm";
    }

    @RequestMapping("/process/{checkedproducts}/{totalPrice}")
    public String saveOrderInformation(HttpSession session, @PathVariable("checkedproducts") String checkedproducts, @PathVariable("totalPrice") double totalPrice) {
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
        return "forward:/shippingInfo/" + checkedproducts + "/" + totalPrice + "/" + ordernumber;
    }

    //APOUHKEUETAI TO SHIPPING INFORMATION ANALOGA ME TO POU UELEI NA TH STEILEI O XRHSTHS THS PARAGGELIAS
    @RequestMapping("/shippingInfo/{checkedproducts}/{totalPrice}/{ordernumber}")
    public String saveOrderInformation(HttpSession session, @PathVariable("ordernumber") CustomerOrder customerOrder, @PathVariable("checkedproducts") String checkedproducts, @PathVariable("totalPrice") double totalPrice, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {
        ShippingInformation si = new ShippingInformation();
        int ordernumber = customerOrder.getOrderNumber();
        //ean to checkbox den einai check tote to shipping info 8a parei tis nees times 
        if (info.isCheck() != true) {
            si = shippingInformationService.newShippingInfoFromShippingInfo(info.getShippingInformation());            // System.out.println( si.getRecipientFirstName());
            int shippinInfoId = si.getShippingInformationId();
            return "forward:/finishOrder/" + checkedproducts + "/" + totalPrice + "/" + ordernumber + "/" + shippinInfoId;
        }
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        CustomerInformation customerInformation = customerInformationSercvice.getCustomerInformation(customerId);
        si = shippingInformationService.newShippingInfoFromCustomerInfo(customerInformation);
        int shippinInfoId = si.getShippingInformationId();

        // return "forward:/order/finishOrder/" + ordernumber + "/" + shippinInfoId;
        return "forward:/finishOrder/" + checkedproducts + "/" + totalPrice + "/" + ordernumber + "/" + shippinInfoId;
    }

    @RequestMapping("/finishOrder/{checkedproducts}/{totalPrice}/{ordernumber}/{shippinInfoId}")
    public String finishOrder(@PathVariable("ordernumber") CustomerOrder customerOrder, HttpSession session, @PathVariable("checkedproducts") String checkedproducts, @PathVariable("totalPrice") double totalPrice, @PathVariable("shippinInfoId") ShippingInformation shippingInformation, @ModelAttribute("sicipDTO") ShippingInfoCustomerInfoPaymentDTO info) {
        Payment payment = info.getPayment();
        //to kala8i ta pernoume apo to shopping cart. Einai se morfh string opote ta id opote ta metatrepoyme se enan pinaka apo int 
        // Start: Getting and Passing the ShoppingCart ids from the checked products
        String[] temp = checkedproducts.split(",");
        List<Integer> customerProducts = new ArrayList();
        for (int i = 0; i < temp.length; i++) {
            customerProducts.add(Integer.parseInt(temp[i])); //metatrepoume tis string times se int k me auton ton tropo dhmiourgoume mia lista me ta shopping cart ids
        }

        for (int i = 0; i < customerProducts.size(); i++) {
            int shoppingCartId = customerProducts.get(i);
            //briskoume to antistoixo kala8o apo ton pinaka me ta id pou pernoume
            ShoppingCart shoppingCart = shoppingCartService.getCart(shoppingCartId); //briskoume to shopping cart mesa apo to service me bash to shoppingCartId
            int quantity = shoppingCart.getQuantity();

            Product productId = shoppingCart.getProductId(); //pairnoume apo shoppingCart to productId 
            System.out.println("shoppingCart.getProductId() " + shoppingCart.getProductId());
            BigDecimal price = shoppingCart.getProductId().getProductPrice();
            BigDecimal productPrice = price.multiply(new BigDecimal(quantity));  //h timh tou product * quantity
            //dhmiourgeitai to order detail 
            // OrderDetails orderDetails = new OrderDetails(null, quantity, BigDecimal.valueOf(totalPrice), customerOrder, payment, productId, shippingInformation);
            OrderDetails orderDetails = new OrderDetails(null, quantity, productPrice, customerOrder, payment, productId, shippingInformation);
            orderDetailsService.saveOrderDetails(orderDetails);
        }

        //ME TO POU MPOUN TSH BASH META SBHNOUME APO TH BASH TO KALOA8I TOU SUGKEKRIMENOU XRHSTH
        //epeidh xtupage la8os otan ta ebaza sthn prohgoumenh loop ta ekana se 3exwristh
        for (int i = 0; i < customerProducts.size(); i++) {
            int shoppingCartId = customerProducts.get(i);
            shoppingCartService.delete(shoppingCartId);
        }
        return "redirect:/customerOrder"; //odhgei ton xrhsth pali sthn selida orderdetails mesw tou customerOrderController
    }

    //otan kanei allages sta stoixeia tou customer Information apo8hkeuontai k sth bash
    @RequestMapping("/saveChangesToCustomerInfo/{checkedproducts}/{totalPrice}")
    public String saveChangesToCustomerInfo(@ModelAttribute("customerInformation") CustomerInformation info, @PathVariable String checkedproducts, @PathVariable("totalPrice") double totalPrice, HttpSession session ) {
        int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
        customerInformationSercvice.update(info);
        return "forward:/order/" + checkedproducts + "/" + totalPrice;
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
    @RequestMapping("/updateCustomerCreditCard/{checkedproducts}/{totalPrice}")
    public String updateCustomerCreditCard(HttpSession session, @ModelAttribute("customerCreditCardSavedDataFromDB") CustomerCreditCard customerCreditCard, @PathVariable String checkedproducts, @PathVariable("totalPrice") double totalPrice) {
        customerCreditCardService.update(customerCreditCard);
        return "forward:/order/" + checkedproducts + "/" + totalPrice;
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
