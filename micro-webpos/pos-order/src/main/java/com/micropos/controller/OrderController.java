package com.micropos.controller;

import com.micropos.api.OrdersApi;
import com.micropos.model.Item;
import com.micropos.model.Order;
import com.micropos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:63342")
public class OrderController implements OrdersApi {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<Order> saveOrder(Order order) {
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> listAllOrders() {
        return new ResponseEntity<>(orderService.allOrders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> showOrderById(Integer orderId) {
        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.OK);
    }
}
