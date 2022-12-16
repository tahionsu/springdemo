package com.example.spring.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "algorithms")
public class AlgorithmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String modelName;

    public AlgorithmEntity() {
    }

    public AlgorithmEntity(Integer id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
