package com.example.spring.demo.repository;

import com.example.spring.demo.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
    PersonEntity findByName(String name);
}
