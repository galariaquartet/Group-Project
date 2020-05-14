package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.dtos.CustomerDto;
import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


  //  @Query("SELECT new com.gquartet.GroupProject.dtos.ProductCategoryImageDto(p.productId , p.productName, p.productDescription, p.productStock, p.productPrice, c.categoryId, c.categoryName) FROM Product p, Category c WHERE p.categoryId = c.categoryId") //native query opou epistrefei mia lista me ta onomata
//    @Query("SELECT new com.gquartet.GroupProject.dtos.ProductCategoryImageDto(p.productId , p.productName, p.productDescription, p.productStock, p.productPrice, c.categoryId, c.categoryName, pi.productFilename) FROM Product p, Category c, ProductImage pi WHERE p.categoryId = c.categoryId AND p.productId = pi.productId") //native query opou epistrefei mia lista me ta onomata
//    List<ProductCategoryImageDto> getProductCategoryImage();
}
