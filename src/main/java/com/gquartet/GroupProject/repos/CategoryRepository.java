package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

//    public Category findCategory(int categoryid);
    
    
//    public List<String> ListCategoryName();
}
