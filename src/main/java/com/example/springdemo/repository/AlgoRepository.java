package com.example.springdemo.repository;

import com.example.springdemo.entity.AlgorithmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgoRepository extends CrudRepository<AlgorithmEntity, Integer> {
    AlgoRepository findByModelName(String modelName);
}
