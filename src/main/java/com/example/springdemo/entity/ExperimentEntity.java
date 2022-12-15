package com.example.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "experiments")
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "algorithm_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AlgorithmEntity algorithm;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pyrometer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PyrometerEntity pyrometer;

    public ExperimentEntity() {

    }

    public ExperimentEntity(Integer id, String name, AlgorithmEntity algorithm, PyrometerEntity pyrometer) {
        this.id = id;
        this.name = name;
        this.algorithm = algorithm;
        this.pyrometer = pyrometer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AlgorithmEntity getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmEntity algorithm) {
        this.algorithm = algorithm;
    }

    public PyrometerEntity getPyrometer() {
        return pyrometer;
    }

    public void setPyrometer(PyrometerEntity pyrometer) {
        this.pyrometer = pyrometer;
    }
}
