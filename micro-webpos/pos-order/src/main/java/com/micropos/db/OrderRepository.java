package com.micropos.db;

import com.micropos.model.Item;
import com.micropos.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();


    public Order saveOrder(Order order) {
        orders.add(order);
        return order;
    }

    public List<Order> allOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        for(Order order : orders) {
            if(order.getOrderNumber() == id) {
                return order;
            }
        }
        return null;
    }
}
