package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public boolean existsCustomerUsername(String username) {
        if (customerRepository.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean existsCustomerEmail(String email) {
        if (customerRepository.findByEmail(email) != null) {
            return true;
        }
        return false;
    }

}
