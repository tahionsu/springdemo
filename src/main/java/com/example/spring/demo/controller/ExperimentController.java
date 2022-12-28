package com.example.spring.demo.controller;

import com.example.spring.demo.entity.ExperimentEntity;
import com.example.spring.demo.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/experiments")
public class ExperimentController {

    private final ExperimentService experimentService;

    public ExperimentController(@Autowired ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody ExperimentEntity experiment) {
        try {
            return ResponseEntity.ok(experimentService.registration(experiment));
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

    @GetMapping("/getById")
    public ResponseEntity<?> getOneExperimentById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(experimentService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getOneExperimentByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(experimentService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteExperiment(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok("Return code: " + experimentService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllExperiment() {
        try {
            return ResponseEntity.ok("Return code: " + experimentService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
