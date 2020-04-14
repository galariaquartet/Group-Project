package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    public Customer findByUsername(String username);
    
    public Customer findByEmail(String email);
    
}
