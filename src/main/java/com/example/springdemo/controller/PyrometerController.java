package com.example.springdemo.controller;

import com.example.springdemo.entity.PyrometerEntity;
import com.example.springdemo.service.PyrometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pyrometers")
public class PyrometerController {

    private final PyrometerService pyrometerService;

    public PyrometerController(@Autowired PyrometerService pyrometerService) {
        this.pyrometerService = pyrometerService;
    }

    @GetMapping("/add")
    @PostMapping
    public ResponseEntity<?> registration(@RequestBody PyrometerEntity pyrometer) {
        try {
            pyrometerService.registration(pyrometer);
            return ResponseEntity.ok("Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPyrometers() {
        try {
            return ResponseEntity.ok(pyrometerService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOnePyrometer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(pyrometerService.getPyrometer(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
