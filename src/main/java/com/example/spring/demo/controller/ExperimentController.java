package com.example.spring.demo.controller;

import com.example.spring.demo.entity.ExperimentEntity;
import com.example.spring.demo.repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spring/demo/experiments")
public class ExperimentController {

    private final ExperimentRepository experimentRepository;

    public ExperimentController(@Autowired ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody ExperimentEntity experiment) {
        try {
            experimentRepository.save(experiment);
            return ResponseEntity.ok("Experiment #"
                    + experiment.getId() + " "
                    + experiment.getName() + " Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllExperiments() {
        try {
            return ResponseEntity.ok(experimentRepository.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getOneExperiment(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(experimentRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deleteExperiment(@RequestParam Integer id) {
        try {
            experimentRepository.deleteById(id);
            return ResponseEntity.ok("Experiment #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
