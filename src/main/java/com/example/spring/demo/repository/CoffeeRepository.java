package com.example.spring.demo.repository;


import com.example.spring.demo.entity.CoffeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CoffeeRepository extends CrudRepository<CoffeeEntity, UUID> {
    CoffeeEntity findByName(String name);
    CoffeeEntity findByGrind(String grind);
}
