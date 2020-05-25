package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Subcategory;
import java.util.List;

public interface SubCategoryService {

    public List<Subcategory> listAll();

    public void save(Subcategory subcategory);

    public Subcategory getSubcategory(Integer id);

    public void delete(Integer id);

    public void update(Subcategory subcategory);

    public List<Subcategory> findSubcategories(int categoryId);

}
