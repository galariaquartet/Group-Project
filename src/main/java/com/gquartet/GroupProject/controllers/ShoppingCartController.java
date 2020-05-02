package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.repos.ShoppingCartRepository;
import com.gquartet.GroupProject.services.CustomerService;
import com.gquartet.GroupProject.services.ProductService;
import com.gquartet.GroupProject.services.ShoppingCartService;
import java.util.List;
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

    @RequestMapping("{customerId}/shoppingCartView")
    public String viewShoppingCartPage(@PathVariable("customerId") int customerId, ModelMap mm) {
        //  List<ShoppingCart> list = shoppingCartService.listAll();
        List<ShoppingCart> list = shoppingCartService.getShoppingCartByCustomerId(customerId); //epistrefei mia lista me ta proionta mono autou tou customer
        mm.addAttribute("shoppingCart", list);
        return "shoppingCartView";
    }

    @RequestMapping("{customerId}/newShoppingCart")
    public String viewNewShoppingCartForm(@PathVariable("customerId") int customerId, ModelMap mm) {
        ShoppingCart shoppingCart = new ShoppingCart();
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());      
        mm.addAttribute("shoppingCart", shoppingCart);
        return "newShoppingCart";
    }

    @RequestMapping("{customerId}/saveShoppingCart")
    public String saveShoppingCart(@PathVariable("customerId") int customerId, ModelMap mm, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
        shoppingCart.setCustomerId(customerService.getCustomer(customerId));
        shoppingCartService.save(shoppingCart);
        return "redirect:/{customerId}/shoppingCartView";
    }

    @RequestMapping("{customerId}/editShoppingCart/{shoppingCartId}")
    public String showEditShoppingCartForm(@PathVariable("customerId") int customerId, @PathVariable("shoppingCartId") int shoppingCartId, ModelMap mm) {
        mm.addAttribute("shoppingCart", shoppingCartService.getShoppingCart(shoppingCartId));
        mm.addAttribute("customerId", customerService.getCustomer(customerId).getCustomerId());
        return "updateFormShoppingCart";
    }

    @RequestMapping("{customerId}/updateShoppingCart")
    public String saveUpdatedShoppingCart(@PathVariable("customerId") int customerId, ModelMap mm, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
        shoppingCart.setCustomerId(customerService.getCustomer(customerId));   
        shoppingCartService.update(shoppingCart);
        return "redirect:/{customerId}/shoppingCartView";
    }
//auto paizei aplws den exw balei na odhgei sth swsth dieu8unsh
    @RequestMapping("/deleteShoppingCart/{shoppingCartId}")
    public String deleteShoppingCart(@PathVariable int shoppingCartId, ModelMap mm) {
        shoppingCartService.delete(shoppingCartId);
        return "redirect:/shoppingCartView";
    }

}
