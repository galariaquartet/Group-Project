/*
 * Created on 12/04/2020 at 22:24:14 GMT+2
 */
package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Customer;

public interface CustomerService {
    
    public void saveCustomer(Customer customer);
    
    public Customer getCustomerByUsername(String username);
    
}
