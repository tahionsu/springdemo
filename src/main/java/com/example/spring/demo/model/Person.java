package com.example.spring.demo.model;

import com.example.spring.demo.entity.BankEntity;
import com.example.spring.demo.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private List<BankEntity> banks;

    public static Person toModel(PersonEntity entity) {
        Person person = new Person();

        person.setId(entity.getId());
        person.setName(entity.getName());
        person.setBanks(entity.getBanks());

        return person;
    }

}
