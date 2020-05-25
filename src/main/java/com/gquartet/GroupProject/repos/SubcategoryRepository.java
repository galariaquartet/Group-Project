package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Subcategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

    @Query("SELECT u FROM Subcategory u where u.categoryId.categoryId=?1")
    public List<Subcategory> findByCategoryId(int categoryId);

}
