package com.example.spring.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "experiments")
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "algorithm_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AlgorithmEntity algorithm;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pyrometer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    @Override
    public String toString() {
        return "ExperimentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", algorithm=" + algorithm +
                ", pyrometer=" + pyrometer +
                '}';
    }
}
