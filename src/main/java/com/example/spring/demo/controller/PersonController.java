package com.example.spring.demo.controller;

import com.example.spring.demo.entity.PersonEntity;
import com.example.spring.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/spring/demo/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(@Autowired PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registration(@RequestBody PersonEntity person) {
        try {
            personService.registration(person);
            return ResponseEntity.ok("Person " + person.getName() + " added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPersons() {
        try {
            return ResponseEntity.ok(personService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getById/")
    public ResponseEntity<?> getOnePersonById(@RequestParam(name = "id") Integer id) {
        try {
            return ResponseEntity.ok(personService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getByName/")
    public ResponseEntity<?> getOnePersonByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(personService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/")
    public ResponseEntity<?> deletePerson(@RequestParam Integer id) {
        try {
            if (personService.existById(id)) {
                personService.deleteById(id);
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
            personService.deleteAll();
            return ResponseEntity.ok("Persons deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
