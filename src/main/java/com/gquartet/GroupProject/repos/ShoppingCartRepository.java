package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
    
}
