package com.micropos.service;

import com.micropos.model.Item;
import com.micropos.model.Order;

import java.util.List;

public interface OrderService {

    public Order saveOrder(Order order);

    public List<Order> allOrders();

    public Order getOrderById(int id);
}
