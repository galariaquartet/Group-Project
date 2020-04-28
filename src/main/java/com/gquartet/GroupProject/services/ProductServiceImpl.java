package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.repos.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired //h spring kalei automata to antikeimeno me olew tis idiothtes me to autowired
    private ProductRepository repo;

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product getProduct(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Product product) {
        Product pr = repo.getOne(product.getProductId());
        
        pr.setProductId(product.getProductId());
        pr.setProductName(product.getProductName());
        pr.setProductDescription(product.getProductDescription());
        pr.setProductStock(product.getProductStock());
        pr.setProductPrice(product.getProductPrice());
        pr.setCategoryId(product.getCategoryId());
//        pr.setProductImageId(product.getProductImageId());
        
        repo.save(pr);
    }

    @Override
    public List<ProductCategoryImageDto> listProductCategoryImage() {
        return repo.getProductCategoryImage();
    }




}
