package com.example.spring.demo.service;

import com.example.spring.demo.entity.ProductEntity;
import com.example.spring.demo.model.Product;
import com.example.spring.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registration(ProductEntity product) {
        return Product.toModel(productRepository.save(product));
    }

    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();

        for (ProductEntity entity : productRepository.findAll()) {
            products.add(Product.toModel(entity));
        }

        return products;
    }

    public Product findById(UUID id) {
        return Product.toModel(productRepository.findById(id).get());
    }

    public Product findByProductName(String productName) {
        return Product.toModel(productRepository.findByProductName(productName));
    }

    public Product findByCost(Double cost) {
        return Product.toModel(productRepository.findByCost(cost));
    }

    public Integer deleteById(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        productRepository.deleteAll();
        return 0;
    }
}
