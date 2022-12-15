package com.example.springdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pyrometers")
public class PyrometerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String port;
    @ManyToOne
    private ExperimentEntity experiment;
}
