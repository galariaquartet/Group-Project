package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ShoppingCart;
import com.gquartet.GroupProject.repos.ShoppingCartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository repo;

    @Override
    public void save(ShoppingCart shoppingCart) {
        repo.save(shoppingCart);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<ShoppingCart> getShoppingCartByCustomerId(int customerId) {
        return repo.getShoppingCartByCustomerId(customerId); //kaloume to query
    }

    @Override
    public ShoppingCart getCartByProduct(int p, int c) {
        return repo.getCartByProduct(p, c);

    }

    @Override
    public ShoppingCart getCart(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public ShoppingCart getShoppingCart(int shoppingCartId) {
        return repo.findByShoppingCartId(shoppingCartId);
    }

}
