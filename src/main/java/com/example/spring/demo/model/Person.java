package com.example.spring.demo.model;

import com.example.spring.demo.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;

    public static Person toModel(PersonEntity entity) {
        Person person = new Person();

        person.setId(entity.getId());
        person.setName(entity.getName());

        return person;
    }

}
