package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.CustomerCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreditCardRepository extends JpaRepository<CustomerCreditCard, Integer>{
    
}
