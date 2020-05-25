package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Customer;

public interface CustomerService{

    public void saveCustomer(Customer customer);

    public Customer getCustomer(Integer id);

    public Customer getCustomerByUsername(String username);

    public Customer getCustomerByEmail(String email);

    public boolean existsCustomerUsername(String username);

    public boolean existsCustomerEmail(String email);

}
