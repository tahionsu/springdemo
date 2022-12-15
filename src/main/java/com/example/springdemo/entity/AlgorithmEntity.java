package com.example.springdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "algorithms")
public class AlgorithmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelName;
    @ManyToOne
    private ExperimentEntity experiment;
}
