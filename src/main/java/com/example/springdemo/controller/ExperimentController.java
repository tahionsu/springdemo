package com.example.springdemo.controller;

import com.example.springdemo.entity.ExperimentEntity;
import com.example.springdemo.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiments")
public class ExperimentController {

    private final ExperimentService experimentService;

    public ExperimentController(@Autowired ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @GetMapping("/add")
    @PostMapping
    public ResponseEntity<?> registration(@RequestBody ExperimentEntity experiment) {
        try {
            experimentService.registration(experiment);
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllExperiments() {
        try {
            return ResponseEntity.ok(experimentService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOneExperiment(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(experimentService.getExperiment(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
