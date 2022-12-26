package com.example.spring.demo.repository;

import com.example.spring.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {
    ProductEntity findByProductName(String productName);

    ProductEntity findByCost(Double cost);
}
