package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Payment;
import java.util.List;

public interface PaymentService {

    public List<Payment> listAll();

    public void save(Payment payment);

    public Payment getPayment(Integer id);

    public void delete(Integer id);

    public void update(Payment payment);

    public List<Payment> findPaymentListByOrderDetailsId(int orderNumber);

}
