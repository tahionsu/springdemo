package com.example.spring.demo.controller;

import com.example.spring.demo.entity.ProductEntity;
import com.example.spring.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody ProductEntity product) {
        try {
            return ResponseEntity.ok(productService.registration(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getProductById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByProductName")
    public ResponseEntity<?> getProductByName(@RequestParam String productName) {
        try {
            return ResponseEntity.ok(productService.findByProductName(productName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByCost")
    public ResponseEntity<?> getProductByCost(@RequestParam Double cost) {
        try {
            return ResponseEntity.ok(productService.findByCost(cost));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteProduct(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + productService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllProducts() {
        try {
            return ResponseEntity.ok("Return code: " + productService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
