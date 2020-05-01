package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import java.util.List;

public interface ProductImageService {

    public List<ProductImage> getAllFiles();

    public void storeFileToDB(ProductImage files);

    List<ProductImage> findProductImageByProductId(int productId);
}
