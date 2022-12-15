package com.example.springdemo.repository;

import com.example.springdemo.entity.ExperimentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends CrudRepository<ExperimentEntity, Integer> {
    ExperimentEntity findByName(String name);
}
