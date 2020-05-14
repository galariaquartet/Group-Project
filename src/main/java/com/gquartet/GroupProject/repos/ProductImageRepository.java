package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.ProductImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    @Query(value = "SELECT * FROM product_image pi, product p WHERE p.product_id = pi.product_id AND p.product_id = ?1", nativeQuery = true) //native query opou epistrefei mia lista me ta onomata
    List<ProductImage> getProductImage(int productId);
}
