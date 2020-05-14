package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Subcategory;
import com.gquartet.GroupProject.repos.SubcategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
    
    @Autowired 
    private SubcategoryRepository repo;

    @Override
    public List<Subcategory> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Subcategory subcategory) {
        repo.save(subcategory);
    }

    @Override
    public Subcategory getSubcategory(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Subcategory subcategory) {
        Subcategory s = repo.getOne(subcategory.getSubcategoryId());

        s.setSubcategoryId(subcategory.getSubcategoryId());
        s.setSubcategoryName(subcategory.getSubcategoryName());
        s.setSubcategoryImageFilepath(subcategory.getSubcategoryImageFilepath());
        s.setCategoryId(subcategory.getCategoryId());
        repo.save(s);
    }

    @Override
    public List<Subcategory> findSubcategories(int categoryId) {
        return repo.findByCategoryId(categoryId);
    }
    
}
