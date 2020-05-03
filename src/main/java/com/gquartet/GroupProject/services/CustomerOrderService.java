package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerOrder;
import java.util.List;

public interface CustomerOrderService {

    public List<CustomerOrder> listAll();

    public void save(CustomerOrder customerOrder);

    public CustomerOrder getCustomerOrder(Integer id);

    public void delete(Integer id);

    public void update(CustomerOrder customerOrder);
    
    public List<CustomerOrder> findCustomerOrderByCustomerId(int customerId);

}
