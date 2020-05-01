package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.repos.ProductImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService{
    
        @Autowired
    private ProductImageRepository repo;
    
    //apo8hkeuei sthn bash to arxeio
    public void storeFileToDB(ProductImage files){
        repo.save(files);
    }
    
    public List<ProductImage> getAllFiles(){
        return repo.findAll();
    }
    
    public List<ProductImage> findProductImageByProductId(int productId){
        return repo.getProductImage(productId);
    }
    
}
