package com.example.spring.demo.controller;

import com.example.spring.demo.entity.CustomerEntity;
import com.example.spring.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody CustomerEntity customer) {
        try {
            return ResponseEntity.ok(customerService.registration(customer));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCustomers() {
        try {
            return ResponseEntity.ok(customerService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getCustomerById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(customerService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByFirstName")
    public ResponseEntity<?> getCustomerByFirstName(@RequestParam String firstName) {
        try {
            return ResponseEntity.ok(customerService.findByFirstName(firstName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByLastName")
    public ResponseEntity<?> getCustomerByLastName(@RequestParam String lastName) {
        try {
            return ResponseEntity.ok(customerService.findByLastName(lastName));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByAge")
    public ResponseEntity<?> getCustomerByAge(@RequestParam Integer age) {
        try {
            return ResponseEntity.ok(customerService.findByAge(age));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteCustomer(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + customerService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllCustomers() {
        try {
            return ResponseEntity.ok("Return code: " + customerService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
