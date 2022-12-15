package com.example.springdemo.service;

import com.example.springdemo.entity.AlgorithmEntity;
import com.example.springdemo.repository.AlgorithmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    public AlgorithmService(@Autowired AlgorithmRepository algorithmRepository) {
        this.algorithmRepository = algorithmRepository;
    }

    public AlgorithmEntity registration(AlgorithmEntity algorithm) {
        return algorithmRepository.save(algorithm);
    }

    public AlgorithmEntity getAlgorithm(Integer id) {
        AlgorithmEntity algorithm = algorithmRepository.findById(id).get();
        if (algorithm.getId() != id) {
            System.out.println("Algorithm not found");
        }
        return algorithm;
    }

    public Iterable<AlgorithmEntity> getAll() {
        return algorithmRepository.findAll();
    }

    public Integer delete(Integer id) {
        algorithmRepository.deleteById(id);
        return id;
    }

}
