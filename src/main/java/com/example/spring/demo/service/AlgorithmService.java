package com.example.spring.demo.service;

import com.example.spring.demo.entity.AlgorithmEntity;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unused")
public class AlgorithmService {

    private final com.example.spring.demo.repository.AlgorithmService algorithmRepository;

    public AlgorithmService(@Autowired com.example.spring.demo.repository.AlgorithmService algorithmRepository) {
        this.algorithmRepository = algorithmRepository;
    }

    public AlgorithmEntity registration(AlgorithmEntity algorithm) {
        return algorithmRepository.save(algorithm);
    }

    public Iterable<AlgorithmEntity> findAll() {
        return algorithmRepository.findAll();
    }

    public AlgorithmEntity findById(Integer id) {
        return algorithmRepository.findById(id).get();
    }

    public AlgorithmEntity findByModelName(String name) {
        return algorithmRepository.findByModelName(name);
    }

    public Integer deleteById(Integer id) {
        algorithmRepository.deleteById(id);
        return id;
    }

    public Integer deleteAll() {
        algorithmRepository.deleteAll();
        return 0;
    }

}
