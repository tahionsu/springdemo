package com.example.spring.demo.controller;

import com.example.spring.demo.entity.TeacherEntity;
import com.example.spring.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(@Autowired TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody TeacherEntity teacher) {
        try {
            return ResponseEntity.ok(teacherService.registration(teacher));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers() {
        try {
            return ResponseEntity.ok(teacherService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getTeacherById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(teacherService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByFirstName")
    public ResponseEntity<?> getTeacherByFirstName(@RequestParam String firstName) {
        try {
            return ResponseEntity.ok(teacherService.findByFirstName(firstName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByLastName")
    public ResponseEntity<?> getTeacherByLastName(@RequestParam String lastName) {
        try {
            return ResponseEntity.ok(teacherService.findByLastName(lastName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByPosition")
    public ResponseEntity<?> getTeacherByPosition(@RequestParam String position) {
        try {
            return ResponseEntity.ok(teacherService.findByPosition(position));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteTeacher(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + teacherService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllTeachers() {
        try {
            return ResponseEntity.ok("Return code: " + teacherService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
