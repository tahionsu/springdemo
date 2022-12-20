package com.example.spring.demo.service;

import com.example.spring.demo.entity.CoffeeEntity;
import com.example.spring.demo.model.Coffee;
import com.example.spring.demo.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeService(@Autowired CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee registration(CoffeeEntity coffee) {
        return Coffee.toModel(coffeeRepository.save(coffee));
    }

    public ArrayList<Coffee> findAll() {
        ArrayList<Coffee> coffees = new ArrayList<>();

        for (CoffeeEntity entity : coffeeRepository.findAll()) {
            coffees.add(Coffee.toModel(entity));
        }

        return coffees;
    }

    public Coffee findById(UUID id) {
        return Coffee.toModel(coffeeRepository.findById(id).get());
    }

    public Coffee findByName(String name) {
        return Coffee.toModel(coffeeRepository.findByName(name));
    }

    public Coffee findByGrind(String grind) {
        return Coffee.toModel(coffeeRepository.findByGrind(grind));
    }

    public Integer deleteById(UUID id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        coffeeRepository.deleteAll();
        return 0;
    }

}
