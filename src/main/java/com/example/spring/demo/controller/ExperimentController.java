package com.example.spring.demo.controller;

import com.example.spring.demo.entity.ExperimentEntity;
import com.example.spring.demo.repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/experiments")
public class ExperimentController {

    private final ExperimentRepository experimentService;

    public ExperimentController(@Autowired ExperimentRepository experimentRepository) {
        this.experimentService = experimentRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody ExperimentEntity experiment) {
        try {
            experimentService.save(experiment);
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllExperiments() {
        try {
            return ResponseEntity.ok(experimentService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOneExperimentById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(experimentService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOneExperimentByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(experimentService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deleteExperiment(@RequestParam Integer id) {
        try {
            if (experimentService.existsById(id)) {
                experimentService.deleteById(id);
            } else {
                return ResponseEntity.badRequest().body("Experiment #" + id + " doesn't exist");
            }
            return ResponseEntity.ok("Experiment #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllExperiment() {
        try {
            experimentService.deleteAll();
            return ResponseEntity.ok("Experiments deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
