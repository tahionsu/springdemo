package com.example.spring.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "pyrometers")
public class PyrometerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String port;

    public PyrometerEntity() {
    }

    public PyrometerEntity(Integer id, String name, String port) {
        this.id = id;
        this.name = name;
        this.port = port;
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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
