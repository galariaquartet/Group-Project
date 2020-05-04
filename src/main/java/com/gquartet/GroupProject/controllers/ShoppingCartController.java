package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.repos.ShoppingCartRepository;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.ProductService;
import com.gquartet.GroupProject.services.ShoppingCartService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/newShoppingCart")
    public String viewNewShoppingCartForm(HttpSession session, ModelMap mm) {
        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
            ShoppingCart shoppingCart = new ShoppingCart();
            mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
            mm.addAttribute("shoppingCart", shoppingCart);
            return "newShoppingCart";
        }
    }

    @RequestMapping("/saveShoppingCart")
    public String saveShoppingCart(HttpSession session, ModelMap mm, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
            shoppingCart.setCustomerId(customerService.getCustomer(customerId));
            shoppingCartService.save(shoppingCart);
            return "redirect:/shoppingCartView";
        }
    }

    @RequestMapping("/editShoppingCart/{shoppingCartId}")
    public String showEditShoppingCartForm(HttpSession session, @PathVariable("shoppingCartId") int shoppingCartId, ModelMap mm) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
            mm.addAttribute("shoppingCart", shoppingCartService.getShoppingCart(shoppingCartId));
            mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
            return "updateFormShoppingCart";
        }
    }

    @RequestMapping("/updateShoppingCart")
    public String saveUpdatedShoppingCart(HttpSession session, ModelMap mm, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {

        if (session.getAttribute("customer") == null) { //me auhn edw thn entolh pairneis ton customer apo to session k ton elegxeis opote o xrhsths den mporei na pros8esei sto url
            mm.addAttribute("login_required", "You have to log in first");
            return "index";
        } else {
            int customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
            shoppingCart.setCustomerId(customerService.getCustomer(customerId));
            shoppingCartService.update(shoppingCart);
            return "redirect:/shoppingCartView";
        }

    }
//auto paizei aplws den exw balei na odhgei sth swsth dieu8unsh

    @RequestMapping("/deleteShoppingCart/{shoppingCartId}")
    public String deleteShoppingCart(@PathVariable int shoppingCartId, ModelMap mm) {
        shoppingCartService.delete(shoppingCartId);
        return "redirect:/shoppingCartView";
    }

}
