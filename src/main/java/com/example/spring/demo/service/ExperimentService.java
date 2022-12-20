package com.example.spring.demo.service;

import com.example.spring.demo.entity.ExperimentEntity;
import com.example.spring.demo.model.Experiment;
import com.example.spring.demo.repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExperimentService {
    private final ExperimentRepository experimentRepository;

    public ExperimentService(@Autowired ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    public Experiment registration(ExperimentEntity experiment) {
        return Experiment.toModel(experimentRepository.save(experiment));
    }

    public ArrayList<Experiment> findAll() {
        ArrayList<Experiment> experiments = new ArrayList<>();

        for (ExperimentEntity entity : experimentRepository.findAll()) {
            experiments.add(Experiment.toModel(entity));
        }

        return experiments;
    }

    public Experiment findById(Integer id) {
        return Experiment.toModel(experimentRepository.findById(id).get());
    }

    public Experiment findByName(String name) {
        return Experiment.toModel(experimentRepository.findByName(name));
    }

    public Integer deleteById(Integer id) {
        if (experimentRepository.existsById(id)) {
            experimentRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        experimentRepository.deleteAll();
        return 0;
    }

}
