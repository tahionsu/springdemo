package com.example.spring.demo.controller;

import com.example.spring.demo.entity.BankEntity;
import com.example.spring.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/banks")
public class BankController {
    private final BankService bankService;

    public BankController(@Autowired BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/add")

    public ResponseEntity<?> registration(@RequestBody BankEntity bank) {
        try {
            return ResponseEntity.ok(bankService.registration(bank));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllBanks() {
        try {
            return ResponseEntity.ok(bankService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOneBankById(@RequestParam(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(bankService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOneBankByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(bankService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deleteBank(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok("Return code: " + bankService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBanks() {
        try {
            return ResponseEntity.ok("Return code: " + bankService.deleteAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
