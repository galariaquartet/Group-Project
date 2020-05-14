package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.repos.ProductImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository repo;

    public List<ProductImage> getAllImages() {
        return repo.findAll();
    }

    //apo8hkeuei sthn bash to arxeio
    public void save (ProductImage productImage) {
        repo.save(productImage);
    }

    public List<ProductImage> findProductImageByProductId(int productId) {
        return repo.getProductImage(productId);
    }

}
