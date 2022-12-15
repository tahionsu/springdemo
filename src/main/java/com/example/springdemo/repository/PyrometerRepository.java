package com.example.springdemo.repository;

import com.example.springdemo.entity.PyrometerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PyrometerRepository extends CrudRepository<PyrometerEntity, Integer> {
    PyrometerEntity findByName(String name);
}
