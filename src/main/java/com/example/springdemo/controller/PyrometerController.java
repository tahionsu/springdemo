package com.example.springdemo.controller;

import com.example.springdemo.entity.PyrometerEntity;
import com.example.springdemo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pyrometers")
public class PyrometerController {

    private final PyrometerRepository pyrometerRepository;

    public PyrometerController(@Autowired PyrometerRepository pyrometerRepository) {
        this.pyrometerRepository = pyrometerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody PyrometerEntity pyrometer) {
        try {
            pyrometerRepository.save(pyrometer);
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPyrometers() {
        try {
            return ResponseEntity.ok(pyrometerRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getOnePyrometer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(pyrometerRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
