package com.example.spring.demo.service;

import com.example.spring.demo.entity.OrderEntity;
import com.example.spring.demo.model.Order;
import com.example.spring.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order registration(OrderEntity order) {
        return Order.toModel(orderRepository.save(order));
    }

    public ArrayList<Order> findAll() {
        ArrayList<Order> orders = new ArrayList<>();

        for (OrderEntity entity : orderRepository.findAll()) {
            orders.add(Order.toModel(entity));
        }

        return orders;
    }

    public Order findById(UUID id) {
        return Order.toModel(orderRepository.findById(id).get());
    }

    public Integer deleteById(UUID id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        orderRepository.deleteAll();
        return 0;
    }
}
