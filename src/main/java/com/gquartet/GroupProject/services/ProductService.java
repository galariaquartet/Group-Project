package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Product;
import java.util.List;

public interface ProductService {

    public List<Product> listAll();

    public void save(Product product);

    public Product getProduct(Integer id);

    public void delete(Integer id);

    public void update(Product product);
    
    public List<String> getDistinctNames();
    
    public List<Product> getProductsByName(String productName);

}
