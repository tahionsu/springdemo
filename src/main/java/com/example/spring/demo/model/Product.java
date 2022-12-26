package com.example.spring.demo.model;

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
public class Product {
    private UUID id;
    private String productName;
    private Double cost;

    public static Product toModel(ProductEntity entity) {
        Product product = new Product();

        product.setId(entity.getId());
        product.setProductName(entity.getProductName());
        product.setCost(entity.getCost());

        return product;
    }
}
