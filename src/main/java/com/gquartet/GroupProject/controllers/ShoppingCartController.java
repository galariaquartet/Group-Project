package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.repos.ShoppingCartRepository;
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

    @RequestMapping("{customerId}/shoppingCartView")
    public String viewShoppingCartPage(@PathVariable("customerId") int customerId, ModelMap mm) {
      //  List<ShoppingCart> list = shoppingCartService.listAll();
        List<ShoppingCart> list = shoppingCartService.getShoppingCartByCustomerId(customerId); //epistrefei mia lista me ta proionta mono autou tou customer
        mm.addAttribute("shoppingCart", list);
        return "ShoppingCartView";
    }

    @RequestMapping("/newShoppingCart")
    public String viewNewShoppingCartForm(ModelMap mm) {
        ShoppingCart shoppingCart = new ShoppingCart();
        mm.addAttribute("shoppingCart", shoppingCart);
        return "newShoppingCart";
    }

    @RequestMapping("/saveShoppingCart")
    public String saveShoppingCart(ModelMap mm, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
        shoppingCartService.save(shoppingCart);
        return "redirect:/shoppingCartView";
    }

    @RequestMapping("/editShoppingCart/{shoppingCartId}")
    public String showEditShoppingCartForm(@PathVariable("shoppingCartId") int shoppingCartId, ModelMap mm) {
        mm.addAttribute("shoppingCart", shoppingCartService.getShoppingCart(shoppingCartId));
        return "updateFormShoppingCart";
    }

    @RequestMapping("/updateShoppingCart")
    public String saveUpdatedShoppingCart(ModelMap mm, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
        shoppingCartService.update(shoppingCart);
        return "redirect:/shoppingCartView";
    }

    @RequestMapping("/deleteShoppingCart/{shoppingCartId}")
    public String deleteShoppingCart(@PathVariable int shoppingCartId, ModelMap mm) {
        shoppingCartService.delete(shoppingCartId);
        return "redirect:/shoppingCartView";
    }

}
