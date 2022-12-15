package com.example.springdemo.service;

import com.example.springdemo.entity.PyrometerEntity;
import com.example.springdemo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PyrometerService {
    private final PyrometerRepository pyrometerRepository;

    public PyrometerService(@Autowired PyrometerRepository pyrometerRepository) {
        this.pyrometerRepository = pyrometerRepository;
    }

    public PyrometerEntity registration(PyrometerEntity pyrometer) {
        return pyrometerRepository.save(pyrometer);
    }

    public PyrometerEntity getPyrometer(Integer id) {
        PyrometerEntity pyrometer = pyrometerRepository.findById(id).get();
        if (pyrometer.getId() != id) {
            System.out.println("Pyrometer not found");
        }
        return pyrometer;
    }

    public Iterable<PyrometerEntity> getAll() {
        return pyrometerRepository.findAll();
    }

    public Integer delete(Integer id) {
        pyrometerRepository.deleteById(id);
        return id;
    }

}
