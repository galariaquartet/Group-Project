/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.repos.OrderDetailsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
    
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getOrderDetails(CustomerOrder id) {
        return orderDetailsRepository.findByOrderNumber(id);
    }

    @Override
    public OrderDetails getOrderDetailsTakeId(Integer id) {
           return orderDetailsRepository.getOne(id);
    
    }
    
}
