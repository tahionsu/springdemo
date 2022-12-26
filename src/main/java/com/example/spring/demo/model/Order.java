package com.example.spring.demo.model;

import com.example.spring.demo.entity.CustomerEntity;
import com.example.spring.demo.entity.OrderEntity;
import com.example.spring.demo.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private UUID id;
    private CustomerEntity customer;
    private ProductEntity product;
    private Integer quantity;

    public static Order toModel(OrderEntity entity) {
        Order order = new Order();

        order.setId(entity.getId());
        order.setCustomer(entity.getCustomer());
        order.setProduct(entity.getProduct());
        order.setQuantity(entity.getQuantity());

        return order;
    }
}
