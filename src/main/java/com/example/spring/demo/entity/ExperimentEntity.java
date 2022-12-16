package com.example.spring.demo.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
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

}
