package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.repos.CustomerOrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderSeviceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository repo;

    @Override
    public List<CustomerOrder> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(CustomerOrder customerOrder) {
        repo.save(customerOrder);
    }

    @Override
    public CustomerOrder getCustomerOrder(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(CustomerOrder customerOrder) {
        CustomerOrder co = repo.getOne(customerOrder.getOrderNumber());

        co.setOrderNumber(customerOrder.getOrderNumber());
        co.setOrderDate(customerOrder.getOrderDate());
        co.setCustomerId(customerOrder.getCustomerId());
        co.setOrderStatusId(customerOrder.getOrderStatusId());

        repo.save(co);
    }

    @Override
    public List<CustomerOrder> findCustomerOrderByCustomerId(int customerId) {
        return repo.getCustomerOrderByCustomerId(customerId);
    }

}
