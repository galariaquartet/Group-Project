package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}
