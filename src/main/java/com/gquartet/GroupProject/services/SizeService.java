package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ProductSize;
import java.util.List;

public interface SizeService {

    public List<ProductSize> listAll();

    public void save(ProductSize productSize);

    public ProductSize getProductSize(Integer id);

    public void delete(Integer id);

    public void update(ProductSize productSize);

}
