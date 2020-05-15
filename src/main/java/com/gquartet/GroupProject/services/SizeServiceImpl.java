package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ProductSize;
import com.gquartet.GroupProject.repos.SizeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository repo;

    @Override
    public List<ProductSize> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(ProductSize productSize) {
        repo.save(productSize);
    }

    @Override
    public ProductSize getProductSize(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(ProductSize productSize) {
        ProductSize ps = new ProductSize();

        ps.setSizeId(productSize.getSizeId());
        ps.setSizeName(productSize.getSizeName());

        repo.save(ps);
    }

}
