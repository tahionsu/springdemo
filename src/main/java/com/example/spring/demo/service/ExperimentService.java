package com.example.spring.demo.service;

import com.example.spring.demo.entity.ExperimentEntity;
import com.example.spring.demo.repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentService {
    private final ExperimentRepository experimentRepository;

    public ExperimentService(@Autowired ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    public ExperimentEntity registration(ExperimentEntity experiment) {
        return experimentRepository.save(experiment);
    }

    public Iterable<ExperimentEntity> findAll() {
        return experimentRepository.findAll();
    }

    public ExperimentEntity findById(Integer id) {
        return experimentRepository.findById(id).get();
    }

    public ExperimentEntity findByName(String name) {
        return experimentRepository.findByName(name);
    }

    public Integer deleteById(Integer id) {
        experimentRepository.deleteById(id);
        return id;
    }

    public Integer deleteAll() {
        experimentRepository.deleteAll();
        return 0;
    }

    public boolean existById(Integer id) {
        return experimentRepository.existsById(id);
    }

}
