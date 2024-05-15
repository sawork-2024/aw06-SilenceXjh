package com.micropos.service;

import com.micropos.db.OrderRepository;
import com.micropos.model.Item;
import com.micropos.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }

    @Override
    public List<Order> allOrders() {
        return orderRepository.allOrders();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }
}
