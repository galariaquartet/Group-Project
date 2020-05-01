package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.ShoppingCart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Query(value = "SELECT * FROM shopping_cart sc WHERE sc.customer_id = ?1", nativeQuery = true) //native query opou epistrefei mia lista me ta proionta tou xrhsth
    List<ShoppingCart> getShoppingCartByCustomerId(int customerId);
}
