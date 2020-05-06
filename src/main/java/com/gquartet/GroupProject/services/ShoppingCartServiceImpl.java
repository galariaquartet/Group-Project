package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.repos.ShoppingCartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    
    @Autowired
    ShoppingCartRepository repo;
    
//    @Override
//    public List<ShoppingCart> listAll() {
//        return repo.findAll();
//    }
    
    @Override
    public void save(ShoppingCart trainer) {
        repo.save(trainer);
    }
    
//    @Override
//    public ShoppingCart getShoppingCart(Integer id) {
//        return repo.getOne(id);
//    }
    
    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
//    @Override
//    public void update(ShoppingCart shoppingCart) {
//        ShoppingCart sc = repo.getOne(shoppingCart.getShoppingCartId());
//        sc.setShoppingCartId(shoppingCart.getShoppingCartId());
//        sc.setQuantity(shoppingCart.getQuantity());
//        sc.setCustomerId(sc.getCustomerId());
//        sc.setProductId(shoppingCart.getProductId());
//        repo.save(sc);
//    }

    @Override
    public List<ShoppingCart> getShoppingCartByCustomerId(int customerId) {
        return repo.getShoppingCartByCustomerId(customerId); //kaloume to query
        }

    @Override
    public ShoppingCart getCartByProduct(int p, int c) {
        return repo.getCartByProduct(p, c);
        
    }

    @Override
    public boolean checkIfShoppingCartQuantityOverflowProductStock(int shoppingCartProductId, int customerId) {
       if(repo.checkShoppingCartQuantityAndProductStock(shoppingCartProductId, customerId) == null){
           return false; //ena den epistrepsei kapoio proion shmainei oti h quantity tou shopping cart einai megaluterh apo to product stock
       }
        return true;
               
    }
    
}
