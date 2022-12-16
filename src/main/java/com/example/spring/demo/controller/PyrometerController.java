package com.example.spring.demo.controller;

import com.example.spring.demo.entity.PyrometerEntity;
import com.example.spring.demo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/pyrometers")
public class PyrometerController {

    private final PyrometerRepository pyrometerRepository;

    public PyrometerController(@Autowired PyrometerRepository pyrometerRepository) {
        this.pyrometerRepository = pyrometerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody PyrometerEntity pyrometer) {
        try {
            pyrometerRepository.save(pyrometer);
            return ResponseEntity.ok("Pyrometer " + pyrometer.getName() + " added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPyrometers() {
        try {
            return ResponseEntity.ok(pyrometerRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOnePyrometerById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(pyrometerRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOnePyrometerByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(pyrometerRepository.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByPort/")
    public ResponseEntity<?> getOnePyrometerByPort(@RequestParam String port) {
        try {
            return ResponseEntity.ok(pyrometerRepository.findByPort(port));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deletePyrometer(@RequestParam Integer id) {
        try {
            if (pyrometerRepository.existsById(id)) {
                pyrometerRepository.deleteById(id);
            } else {
                return ResponseEntity.badRequest().body("Pyrometer #" + id + " doesn't exist");
            }
            return ResponseEntity.ok("Pyrometer #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllPyrometer() {
        try {
            pyrometerRepository.deleteAll();
            return ResponseEntity.ok("Pyrometers deleted successfully"statu);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
