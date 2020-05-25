package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.dtos.CustomerDto;
import com.gquartet.GroupProject.models.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByUsername(String username);//briskei ton customer analoga me to onoma tou 

    public Customer findByEmail(String email);//briskei ton customer analoga me to onoma tou

    @Query("SELECT new com.gquartet.GroupProject.dtos.CustomerDto(c.username , c.email) FROM Customer c") 
    List<CustomerDto> getCustomerUsernameEmail();

}
