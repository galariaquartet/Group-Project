package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ShoppingCart;
import java.util.List;

public interface ShoppingCartService {

    public List<ShoppingCart> listAll();

    public void save(ShoppingCart trainer);

    public ShoppingCart getShoppingCart(Integer id);

    public void delete(Integer id);

    public void update(ShoppingCart shoppingCart);
    
    public  List<ShoppingCart> getShoppingCartByCustomerId(int customerId);

}
