package com.example.spring.demo.controller;

import com.example.spring.demo.entity.OrderEntity;
import com.example.spring.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody OrderEntity order) {
        try {
            return ResponseEntity.ok(orderService.registration(order));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllOrders() {
        try {
            return ResponseEntity.ok(orderService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getOrderById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(orderService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteOrder(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + orderService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllOrders() {
        try {
            return ResponseEntity.ok("Return code: " + orderService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
