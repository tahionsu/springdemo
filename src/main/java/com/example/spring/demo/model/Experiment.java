package com.example.spring.demo.model;

import com.example.spring.demo.entity.AlgorithmEntity;
import com.example.spring.demo.entity.ExperimentEntity;
import com.example.spring.demo.entity.PyrometerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experiment {
    private Integer id;
    private String name;
    private AlgorithmEntity algorithm;
    private PyrometerEntity pyrometer;

    public static Experiment toModel(ExperimentEntity entity) {
        Experiment experiment = new Experiment();

        experiment.setId(entity.getId());
        experiment.setName(entity.getName());
        experiment.setAlgorithm(entity.getAlgorithm());
        experiment.setPyrometer(entity.getPyrometer());

        return experiment;
    }

}
