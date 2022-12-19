package com.example.spring.demo.controller;

import com.example.spring.demo.entity.BankEntity;
import com.example.spring.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/banks")
public class BankController {
    private final BankRepository bankRepository;

    public BankController(@Autowired BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody BankEntity bank) {
        try {
            bankRepository.save(bank);
            return ResponseEntity.ok("Bank " + bank.getName() + " added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllBanks() {
        try {
            return ResponseEntity.ok(bankRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOneBankById(@RequestParam(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(bankRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOneBankByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(bankRepository.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deleteBank(@RequestParam Integer id) {
        try {
            if (bankRepository.existsById(id)) {
                bankRepository.deleteById(id);
            } else {
                return ResponseEntity.badRequest().body("Bank #" + id + " doesn't exist");
            }
            return ResponseEntity.ok("Bank #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBanks() {
        try {
            bankRepository.deleteAll();
            return ResponseEntity.ok("Banks deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
