package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.OrderDetails;
import java.util.List;

public interface OrderDetailsService {

    public void saveOrderDetails(OrderDetails orderDetails);

    public List<OrderDetails> getOrderDetails(CustomerOrder id);

    public OrderDetails getOrderDetailsTakeId(Integer id);

}
