package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.OrderStatus;
import com.gquartet.GroupProject.repos.OrderStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository repo;

    @Override
    public List<OrderStatus> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(OrderStatus orderStatus) {
        repo.save(orderStatus);
    }

    @Override
    public OrderStatus getOrderStatus(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(OrderStatus orderStatus) {
        OrderStatus os = repo.getOne(orderStatus.getOrderStatusId());
        os.setOrderStatusId(orderStatus.getOrderStatusId());
        os.setOrderStatusName(orderStatus.getOrderStatusName());
        repo.save(os);
    }

}
