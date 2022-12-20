package com.example.spring.demo.service;


import com.example.spring.demo.entity.PersonEntity;
import com.example.spring.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity registration(PersonEntity person) {
        return personRepository.save(person);
    }

    public Iterable<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    public PersonEntity findById(Integer id) {
        return personRepository.findById(id).get();
    }

    public PersonEntity findByName(String name) {
        return personRepository.findByName(name);
    }

    public Integer deleteById(Integer id) {
        personRepository.deleteById(id);
        return id;
    }

    public Integer deleteAll() {
        personRepository.deleteAll();
        return 0;
    }

    public boolean existById(Integer id) {
        return personRepository.existsById(id);
    }

}
