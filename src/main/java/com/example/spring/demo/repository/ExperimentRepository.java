package com.example.spring.demo.repository;

import com.example.spring.demo.entity.ExperimentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends CrudRepository<ExperimentEntity, Integer> {
    ExperimentEntity findByName(String name);
}
