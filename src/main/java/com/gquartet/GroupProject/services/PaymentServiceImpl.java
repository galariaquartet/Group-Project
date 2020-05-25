package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.repos.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repo;

    @Override
    public List<Payment> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Payment payment) {
        repo.save(payment);
    }

    @Override
    public Payment getPayment(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Payment payment) {
        Payment p = repo.getOne(payment.getPaymentId());
        p.setPaymentId(payment.getPaymentId());
        p.setPaymentName(payment.getPaymentName());
        repo.save(p);
    }

    @Override
    public List<Payment> findPaymentListByOrderDetailsId(int orderNumber) {
        return repo.findPaymentByOrderDetailsId(orderNumber);
    }

}
