package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer>{
    
}
