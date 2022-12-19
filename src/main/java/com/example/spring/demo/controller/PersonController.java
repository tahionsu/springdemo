package com.example.spring.demo.controller;

import com.example.spring.demo.entity.PersonEntity;
import com.example.spring.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody PersonEntity person) {
        try {
            personRepository.save(person);
            return ResponseEntity.ok("Person " + person.getName() + " added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPersons() {
        try {
            return ResponseEntity.ok(personRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOnePersonById(@RequestParam(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(personRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOnePersonByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(personRepository.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deletePerson(@RequestParam Integer id) {
        try {
            if (personRepository.existsById(id)) {
                personRepository.deleteById(id);
            } else {
                return ResponseEntity.badRequest().body("Person #" + id + " doesn't exist");
            }
            return ResponseEntity.ok("Person #" + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBanks() {
        try {
            personRepository.deleteAll();
            return ResponseEntity.ok("Persons deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
