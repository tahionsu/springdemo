package com.example.spring.demo.controller;


import com.example.spring.demo.entity.CoffeeEntity;
import com.example.spring.demo.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(@Autowired CoffeeService coffeeService1) {
        this.coffeeService = coffeeService1;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody CoffeeEntity coffee) {
        try {
            return ResponseEntity.ok(coffeeService.registration(coffee));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCoffees() {
        try {
            return ResponseEntity.ok(coffeeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getOneCoffeeById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(coffeeService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getOneCoffeeByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(coffeeService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByGrind")
    public ResponseEntity<?> getOneCoffeeByGrind(@RequestParam String grind) {
        try {
            return ResponseEntity.ok(coffeeService.findByGrind(grind));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteCoffee(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + coffeeService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllCoffees() {
        try {
            return ResponseEntity.ok("Return code: " + coffeeService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
