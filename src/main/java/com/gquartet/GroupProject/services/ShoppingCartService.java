package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ShoppingCart;
import java.util.List;

public interface ShoppingCartService {

    public void save(ShoppingCart trainer);

    public void delete(Integer id);

    public List<ShoppingCart> getShoppingCartByCustomerId(int customerId);

    public ShoppingCart getCartByProduct(int p, int c);

    public ShoppingCart getCart(Integer id);

    public ShoppingCart getShoppingCart(int shoppingCartId);

}
