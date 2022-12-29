package com.example.spring.demo.controller;

import com.example.spring.demo.entity.ScheduleEntity;
import com.example.spring.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.UUID;

@RestController
@RequestMapping("/spring/demo/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(@Autowired ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody ScheduleEntity schedule) {
        try {
            return ResponseEntity.ok(scheduleService.registration(schedule));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllSchedules() {
        try {
            return ResponseEntity.ok(scheduleService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getScheduleById(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok(scheduleService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByAuditory")
    public ResponseEntity<?> getScheduleByAuditory(@RequestParam String auditory) {
        try {
            return ResponseEntity.ok(scheduleService.findByAuditory(auditory));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByDateTime")
    public ResponseEntity<?> getScheduleByDateTime(@RequestParam Date dateTime) {
        try {
            return ResponseEntity.ok(scheduleService.findByDateTime(dateTime));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> deleteSchedule(@RequestParam UUID id) {
        try {
            return ResponseEntity.ok("Return code: " + scheduleService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllSchedules() {
        try {
            return ResponseEntity.ok("Return code: " + scheduleService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
