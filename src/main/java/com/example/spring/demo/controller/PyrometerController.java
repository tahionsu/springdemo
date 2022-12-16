package com.example.spring.demo.controller;

import com.example.spring.demo.entity.PyrometerEntity;
import com.example.spring.demo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spring/demo/pyrometers")
public class PyrometerController {

    private final PyrometerRepository pyrometerRepository;

    public PyrometerController(@Autowired PyrometerRepository pyrometerRepository) {
        this.pyrometerRepository = pyrometerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody PyrometerEntity pyrometer) {
        try {
            pyrometerRepository.save(pyrometer);
            return ResponseEntity.ok("Pyrometer " + pyrometer.getName() + " added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPyrometers() {
        try {
            return ResponseEntity.ok(pyrometerRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getOnePyrometer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(pyrometerRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deletePyrometer(@RequestParam Integer id) {
        try {
            pyrometerRepository.deleteById(id);
            return ResponseEntity.ok("Pyrometer #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
