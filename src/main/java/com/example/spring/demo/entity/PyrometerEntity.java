package com.example.spring.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pyrometers")
public class PyrometerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String port;

}
