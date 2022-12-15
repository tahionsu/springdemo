package com.example.springdemo.service;

import com.example.springdemo.entity.ExperimentEntity;
import com.example.springdemo.repository.ExperimentRepository;
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

    public ExperimentEntity getExperiment(Integer id) {
        ExperimentEntity experiment = experimentRepository.findById(id).get();
        if (experiment.getId() != id) {
            System.out.println("Experiment not found");
        }
        return experiment;
    }

    public Iterable<ExperimentEntity> getAll() {
        return experimentRepository.findAll();
    }

    public Integer delete(Integer id) {
        experimentRepository.deleteById(id);
        return id;
    }

}
