package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Category;
import java.util.List;
import org.springframework.stereotype.Service;

public interface CategoryService {

    public List<Category> listAll();

    public void save(Category category);

    public Category getCategory(Integer id);

    public void delete(Integer id);

    public void update(Category category);
    
//    public Category cate(Integer id); 

}
