package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.models.ProductImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreditCardRepository extends JpaRepository<CustomerCreditCard, Integer> {

    @Query(value = "SELECT * FROM customer_credit_card ccc  WHERE customer_id = ?1", nativeQuery = true) //native query opou epistrefei mia lista me ta onomata
    CustomerCreditCard getCustomerCreditCardByCustomerId(int customerId);
}
