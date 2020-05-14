package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import java.util.List;

public interface ProductImageService {

    public List<ProductImage> getAllImages();

    public void save(ProductImage productImage);

    List<ProductImage> findProductImageByProductId(int productId);
}
