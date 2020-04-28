package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.repos.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired 
    private CategoryRepository repo;

    @Override
    public List<Category> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Category category) {
        repo.save(category);
    }

    @Override
    public Category getCategory(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Category category) {
        Category c = repo.getOne(category.getCategoryId());
        c.setCategoryId(category.getCategoryId());
        c.setCategoryName(category.getCategoryName());
        c.setCategoryImage(category.getCategoryImage());
        c.setFilename(category.getFilename());
        repo.save(c);
    }

//    @Override
//    public List<String> ListCategoryName() {
//        List<String> categoryNames = repo.ListCategoryName();      
//        return categoryNames;
//    }

//    @Override
//    public Category cate(Integer id) {
//       return repo.findCategory(id);
//    }

}
