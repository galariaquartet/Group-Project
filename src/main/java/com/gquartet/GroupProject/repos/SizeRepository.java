package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<ProductSize, Integer> {

}
