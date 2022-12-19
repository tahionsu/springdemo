package com.example.spring.demo.controller;

import com.example.spring.demo.entity.AlgorithmEntity;
import com.example.spring.demo.repository.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/algorithms")
public class AlgorithmController {

    private final AlgorithmService algorithmService;

    public AlgorithmController(@Autowired AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody AlgorithmEntity algorithm) {
        try {
            algorithmService.save(algorithm);
            return ResponseEntity.ok("Algorithm " + algorithm.getModelName() + " added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllAlgorithms() {
        try {
            return ResponseEntity.ok(algorithmService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOneAlgorithmById(@RequestParam(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(algorithmService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOneAlgorithmByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(algorithmService.findByModelName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deleteAlgorithm(@RequestParam Integer id) {
        try {
            if (algorithmService.existsById(id)) {
                algorithmService.deleteById(id);
            } else {
                return ResponseEntity.badRequest().body("Algorithm #" + id + " doesn't exist");
            }
            return ResponseEntity.ok("Algorithm #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllAlgorithms() {
        try {
            algorithmService.deleteAll();
            return ResponseEntity.ok("Algorithms deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
