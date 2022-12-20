package com.example.spring.demo.service;

import com.example.spring.demo.entity.AlgorithmEntity;
import com.example.spring.demo.model.Algorithm;
import com.example.spring.demo.repository.AlgorithmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@SuppressWarnings("unused")
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    public AlgorithmService(@Autowired AlgorithmRepository algorithmRepository) {
        this.algorithmRepository = algorithmRepository;
    }

    public Algorithm registration(AlgorithmEntity algorithm) {
        return Algorithm.toModel(algorithmRepository.save(algorithm));
    }

    public ArrayList<Algorithm> findAll() {
        ArrayList<Algorithm> algorithms = new ArrayList<>();

        for (AlgorithmEntity entity : algorithmRepository.findAll()) {
            algorithms.add(Algorithm.toModel(entity));
        }

        return algorithms;
    }

    public Algorithm findById(Integer id) {
        return Algorithm.toModel(algorithmRepository.findById(id).get());
    }

    public Algorithm findByModelName(String name) {
        return Algorithm.toModel(algorithmRepository.findByModelName(name));
    }

    public Integer deleteById(Integer id) {
        if (algorithmRepository.existsById(id)) {
            algorithmRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        algorithmRepository.deleteAll();
        return 0;
    }

}
