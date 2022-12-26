package com.example.spring.demo.repository;

import com.example.spring.demo.entity.OrderEntity;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<OrderEntity, UUID> {
    OrderEntity findByQuantity(Integer quantity);
}
