package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
