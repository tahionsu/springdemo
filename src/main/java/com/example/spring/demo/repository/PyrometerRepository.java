package com.example.spring.demo.repository;

import com.example.spring.demo.entity.PyrometerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PyrometerRepository extends CrudRepository<PyrometerEntity, Integer> {
    PyrometerEntity findByName(String name);

    PyrometerEntity findByPort(String port);
}
