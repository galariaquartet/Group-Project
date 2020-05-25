package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.OrderStatus;
import java.util.List;

public interface OrderStatusService {

    public List<OrderStatus> listAll();

    public void save(OrderStatus orderStatus);

    public OrderStatus getOrderStatus(Integer id);

    public void delete(Integer id);

    public void update(OrderStatus orderStatus);

}
