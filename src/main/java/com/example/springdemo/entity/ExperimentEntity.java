package com.example.springdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "experiments")
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "algorithms", fetch = FetchType.EAGER)
    private Set<AlgorithmEntity> algorithmEntities;
    @OneToMany(mappedBy = "pyrometers", fetch = FetchType.EAGER)
    private Set<PyrometerEntity> pyrometerEntities;
}
