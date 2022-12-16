package com.example.spring.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "algorithms")
public class AlgorithmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String modelName;

}
