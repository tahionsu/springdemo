package com.example.spring.demo.controller;

import com.example.spring.demo.entity.PyrometerEntity;
import com.example.spring.demo.service.PyrometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/pyrometers")
public class PyrometerController {

    private final PyrometerService pyrometerService;

    public PyrometerController(@Autowired PyrometerService pyrometerRepository) {
        this.pyrometerService = pyrometerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody PyrometerEntity pyrometer) {
        try {
            return ResponseEntity.ok(pyrometerService.registration(pyrometer));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPyrometers() {
        try {
            return ResponseEntity.ok(pyrometerService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOnePyrometerById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(pyrometerService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOnePyrometerByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(pyrometerService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByPort/")
    public ResponseEntity<?> getOnePyrometerByPort(@RequestParam String port) {
        try {
            return ResponseEntity.ok(pyrometerService.findByPort(port));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deletePyrometer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok("Return code: " + pyrometerService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllPyrometer() {
        try {
            return ResponseEntity.ok("Return code: " + pyrometerService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
