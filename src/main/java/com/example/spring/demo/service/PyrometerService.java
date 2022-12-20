package com.example.spring.demo.service;


import com.example.spring.demo.entity.PyrometerEntity;
import com.example.spring.demo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PyrometerService {
    private final PyrometerRepository pyrometerRepository;

    public PyrometerService(@Autowired PyrometerRepository pyrometerRepository) {
        this.pyrometerRepository = pyrometerRepository;
    }

    public PyrometerEntity registration(PyrometerEntity person) {
        return pyrometerRepository.save(person);
    }

    public Iterable<PyrometerEntity> findAll() {
        return pyrometerRepository.findAll();
    }

    public PyrometerEntity findById(Integer id) {
        return pyrometerRepository.findById(id).get();
    }

    public PyrometerEntity findByName(String name) {
        return pyrometerRepository.findByName(name);
    }

    public PyrometerEntity findByPort(String port) {
        return pyrometerRepository.findByPort(port);
    }

    public Integer deleteById(Integer id) {
        pyrometerRepository.deleteById(id);
        return id;
    }

    public Integer deleteAll() {
        pyrometerRepository.deleteAll();
        return 0;
    }

    public boolean existById(Integer id) {
        return pyrometerRepository.existsById(id);
    }

}
