package com.example.spring.demo.service;


import com.example.spring.demo.entity.PersonEntity;
import com.example.spring.demo.model.Person;
import com.example.spring.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person registration(PersonEntity person) {
        return Person.toModel(personRepository.save(person));
    }

    public ArrayList<Person> findAll() {
        ArrayList<Person> people = new ArrayList<>();

        for (PersonEntity entity : personRepository.findAll()) {
            people.add(Person.toModel(entity));
        }

        return people;
    }

    public Person findById(Integer id) {
        return Person.toModel(personRepository.findById(id).get());
    }

    public Person findByName(String name) {
        return Person.toModel(personRepository.findByName(name));
    }

    public Integer deleteById(Integer id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        personRepository.deleteAll();
        return 0;
    }

}
