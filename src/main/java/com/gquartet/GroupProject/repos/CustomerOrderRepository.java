package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.models.CustomerOrder;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query(value = "SELECT * FROM customer_order co  WHERE co.customer_id = ?1 ORDER BY co.order_number DESC", nativeQuery = true) //native query opou epistrefei mia lista me ta onomata
    List<CustomerOrder> getCustomerOrderByCustomerId(int customerId);
    
}
