package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.ProductService;
import com.gquartet.GroupProject.services.ShoppingCartService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/shoppingCartView")
    public String viewShoppingCartPage(HttpSession session, ModelMap mm) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
            List<ShoppingCart> list = shoppingCartService.getShoppingCartByCustomerId(customerId); //epistrefei mia lista me ta proionta mono autou tou customer
            mm.addAttribute("shoppingCart", list);
            return "shoppingCartView";
        }
    }

    @RequestMapping("/addToCart/{productId}" )
    public String showEditShoppingCartForm(@RequestParam("quantity") int quantity, HttpSession session, @PathVariable("productId") int productId, ModelMap mm) {
        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            Customer customer = ((Customer) session.getAttribute("customer"));
            
            int customerId = customer.getCustomerId();
            ShoppingCart shoppingCart = shoppingCartService.getCartByProduct(productId, customerId);
            //tsekaroume ena uparxei sto kala8i me bash to productID ena proion ean den uparxei dhmiourgoume ena kainourgio kala8i k to pros8etoume
            if (shoppingCart == null ) {
                shoppingCart = new ShoppingCart();
                shoppingCart.setCustomerId(customer);
                Product product = productService.getProduct(productId);
                shoppingCart.setProductId(product);

                //TODO change quantity and check ean uperbainei to orio tou product
                shoppingCart.setQuantity(quantity);

            } else {
                int quan = (shoppingCart.getQuantity()) + quantity;
                shoppingCart.setQuantity(quan);
            }
            shoppingCartService.save(shoppingCart);
            return "redirect:/products";
        }
    }

//auto paizei aplws den exw balei na odhgei sth swsth dieu8unsh
    @RequestMapping("/deleteShoppingCart/{shoppingCartId}")
    public String deleteShoppingCart(@PathVariable int shoppingCartId, ModelMap mm) {
        shoppingCartService.delete(shoppingCartId);
        return "redirect:/shoppingCartView";
    }
    
//    @ResponseBody
//    @RequestMapping("updatequantity/{quantity}/{cartid}")
//    public void updateQuantity(@PathVariable("quantity") int quantity, @PathVariable("cartid") int cartid){
//        System.out.println("Quantity = " + quantity);
    @ResponseBody
    @RequestMapping("updatequantity/{quantity}")
    public void updateQuantity(@PathVariable("quantity") int quantity){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$Quantity = " + quantity);
       // System.out.println("Cart id = " + cartid);

//        System.out.println("%%%%%%%%%%%%%%"+ shoppingCart.getQuantity());
//        System.out.println("%%%%%%%%%%%%%%"+ shoppingCart);
// 
        
        
    }
}
