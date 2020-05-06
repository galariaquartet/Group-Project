package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ShoppingCart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Query(value = "SELECT * FROM shopping_cart sc WHERE sc.customer_id = ?1", nativeQuery = true) //native query opou epistrefei mia lista me ta proionta tou xrhsth
    List<ShoppingCart> getShoppingCartByCustomerId(int customerId);

    
    @Query(value = "SELECT * FROM shopping_cart sc  WHERE sc.product_id = ?1 AND customer_id =?2" , nativeQuery = true) //native query opou epistrefei mia lista me ta proionta tou xrhsth
    ShoppingCart getCartByProduct (int productId, int customerId);
    
    @Query(value = "SELECT * FROM shopping_cart sc, product p WHERE sc.product_id = p.product_id AND sc.quantity <= p.product_stock AND p.product_id = ?1 AND sc.customer_id = ?2" , nativeQuery = true) //native query opou epistrefei mia lista me ta proionta tou xrhsth
    ShoppingCart checkShoppingCartQuantityAndProductStock (int shoppingCartProductId, int customerId);
}
