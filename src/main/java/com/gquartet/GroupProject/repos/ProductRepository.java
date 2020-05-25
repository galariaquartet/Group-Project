package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    @Query(value ="SELECT DISTINCT (product_name) FROM product;" , nativeQuery = true)
    List<String> getDistinctNames();
    
    @Query(value ="SELECT * FROM product WHERE product_name = ?1" , nativeQuery = true)
    List<Product> getProductsByName(String productName);
}
