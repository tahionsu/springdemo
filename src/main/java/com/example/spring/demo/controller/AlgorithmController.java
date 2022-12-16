package com.example.spring.demo.controller;

import com.example.spring.demo.entity.AlgorithmEntity;
import com.example.spring.demo.repository.AlgorithmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/algorithms")
public class AlgorithmController {

    private final AlgorithmRepository algoRepository;

    public AlgorithmController(@Autowired AlgorithmRepository algoRepository) {
        this.algoRepository = algoRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody AlgorithmEntity algorithm) {
        try {
            algoRepository.save(algorithm);
            return ResponseEntity.ok("Algorithm " + algorithm.getModelName() + " added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllAlgorithms() {
        try {
            return ResponseEntity.ok(algoRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOneAlgorithmById(@RequestParam(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(algoRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOneAlgorithmByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(algoRepository.findByModelName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deleteAlgorithm(@RequestParam Integer id) {
        try {
            algoRepository.deleteById(id);
            return ResponseEntity.ok("Algorithm #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
