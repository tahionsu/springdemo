package com.example.spring.demo.repository;

import com.example.spring.demo.entity.AlgorithmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmRepository extends CrudRepository<AlgorithmEntity, Integer> {
    AlgorithmRepository findByModelName(String modelName);
}
