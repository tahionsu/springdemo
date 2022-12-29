package com.example.spring.demo.controller;

import com.example.spring.demo.entity.SubjectEntity;
import com.example.spring.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(@Autowired SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody SubjectEntity subject) {
        try {
            return ResponseEntity.ok(subjectService.registration(subject));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllSubjects() {
        try {
            return ResponseEntity.ok(subjectService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getSubjectById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(subjectService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByFirstName")
    public ResponseEntity<?> getSubjectBySubjectName(@RequestParam String subjectName) {
        try {
            return ResponseEntity.ok(subjectService.findBySubjectName(subjectName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteSubject(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + subjectService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllSubjects() {
        try {
            return ResponseEntity.ok("Return code: " + subjectService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
