package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.dtos.CustomerDto;
import com.gquartet.GroupProject.models.Customer;
import java.util.List;

public interface CustomerService {

    public void saveCustomer(Customer customer);

    public Customer getCustomer(Integer id);
    
    public Customer getCustomerByUsername(String username);
    
    public Customer getCustomerByEmail (String email);

//    public Customer getCustomerByUsername(String username);
//
    public boolean existsCustomerUsername(String username);
//
//    public List<CustomerDto> listUsernameEmail();
//
    public boolean existsCustomerEmail(String email);

}
