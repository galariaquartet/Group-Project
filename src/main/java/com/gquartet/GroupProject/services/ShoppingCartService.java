package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ShoppingCart;
import java.util.List;

public interface ShoppingCartService {

//    public List<ShoppingCart> listAll();

    public void save(ShoppingCart trainer);

//    public ShoppingCart getShoppingCart(Integer id);

    public void delete(Integer id);

//    public void update(ShoppingCart shoppingCart);
    
    public  List<ShoppingCart> getShoppingCartByCustomerId(int customerId);
    
    public ShoppingCart getCartByProduct (int p,int c);
    
    public boolean checkIfShoppingCartQuantityOverflowProductStock(int shoppingCartProductId, int customerId);
    
}
