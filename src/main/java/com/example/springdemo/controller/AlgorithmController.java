package com.example.springdemo.controller;

import com.example.springdemo.entity.AlgorithmEntity;
import com.example.springdemo.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/algorithms")
public class AlgorithmController {

    private final AlgorithmService algorithmService;

    public AlgorithmController(@Autowired AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @GetMapping("/add")
    @PostMapping
    public ResponseEntity<?> registration(@RequestBody AlgorithmEntity algorithm) {
        try {
            algorithmService.registration(algorithm);
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllAlgorithms() {
        try {
            return ResponseEntity.ok(algorithmService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOneAlgorithm(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(algorithmService.getAlgorithm(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
