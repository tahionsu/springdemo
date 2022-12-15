package com.example.springdemo.controller;

import com.example.springdemo.entity.AlgorithmEntity;
import com.example.springdemo.repository.AlgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/algorithms")
public class AlgorithmController {

    private final AlgoRepository algoRepository;

    public AlgorithmController(@Autowired AlgoRepository algoRepository) {
        this.algoRepository = algoRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody AlgorithmEntity algorithm) {
        try {
            algoRepository.save(algorithm);
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllAlgorithms() {
        try {
            return ResponseEntity.ok(algoRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getOneAlgorithm(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(algoRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
