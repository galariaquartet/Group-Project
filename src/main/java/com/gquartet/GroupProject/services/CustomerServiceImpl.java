/*
 * Created on 12/04/2020 at 22:24:05 GMT+2
 */
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
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
    
}
