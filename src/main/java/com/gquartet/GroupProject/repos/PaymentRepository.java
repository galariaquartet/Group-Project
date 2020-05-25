package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "SELECT * FROM order_details od, payment p WHERE od.payment_id = p.payment_id AND od.order_number =?1 ", nativeQuery = true)
    public List<Payment> findPaymentByOrderDetailsId(int orderNumber);

}
