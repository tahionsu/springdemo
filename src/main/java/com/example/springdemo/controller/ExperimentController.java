package com.example.springdemo.controller;

import com.example.springdemo.entity.ExperimentEntity;
import com.example.springdemo.repository.AlgoRepository;
import com.example.springdemo.repository.ExperimentRepository;
import com.example.springdemo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiments")
public class ExperimentController {

    private final ExperimentRepository experimentRepository;
    private final AlgoRepository algoRepository;
    private final PyrometerRepository pyrometerRepository;

    public ExperimentController(@Autowired ExperimentRepository experimentRepository, AlgoRepository algoRepository, PyrometerRepository pyrometerRepository) {
        this.experimentRepository = experimentRepository;
        this.algoRepository = algoRepository;
        this.pyrometerRepository = pyrometerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody ExperimentEntity experiment) {
        try {
            experimentRepository.save(
                    new ExperimentEntity(experiment.getId(), experiment.getName(),
                            experiment.getAlgorithm(), experiment.getPyrometer()));
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllExperiments() {
        try {
            return ResponseEntity.ok(experimentRepository.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getOneExperiment(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(experimentRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
