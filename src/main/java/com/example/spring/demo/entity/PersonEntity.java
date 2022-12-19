package com.example.spring.demo.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Person {
    @Id
    Integer id;
    String name;
}
