package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query(value = "SELECT * FROM customer_order co  WHERE co.customer_id = ?1", nativeQuery = true) //native query opou epistrefei mia lista me ta onomata
    CustomerOrder getCustomerOrderByCustomerId(int customerId);
}
