package com.gquartet.GroupProject.services;

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
//        pr.setProductSize(product.getProductSize());
//        pr.setProductColor(product.getProductColor());
//        pr.setProductMaterial(product.getProductMaterial());
//        pr.setProductGender(product.getProductGender());
        pr.setProductStock(product.getProductStock());
        pr.setProductPrice(product.getProductPrice());
        pr.setSubcategoryId(product.getSubcategoryId());

        repo.save(pr);
    }

    @Override
    public List<String> getDistinctNames() {
        return repo.getDistinctNames();
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return repo.getProductsByName(productName);
    }

}
