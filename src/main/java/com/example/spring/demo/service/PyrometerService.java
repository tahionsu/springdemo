package com.example.spring.demo.service;


import com.example.spring.demo.entity.PyrometerEntity;
import com.example.spring.demo.model.Pyrometer;
import com.example.spring.demo.repository.PyrometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PyrometerService {
    private final PyrometerRepository pyrometerRepository;

    public PyrometerService(@Autowired PyrometerRepository pyrometerRepository) {
        this.pyrometerRepository = pyrometerRepository;
    }

    public Pyrometer registration(PyrometerEntity person) {
        return Pyrometer.toModel(pyrometerRepository.save(person));
    }

    public ArrayList<Pyrometer> findAll() {
        ArrayList<Pyrometer> pyrometers = new ArrayList<>();

        for (PyrometerEntity entity : pyrometerRepository.findAll()) {
            pyrometers.add(Pyrometer.toModel(entity));
        }
        return pyrometers;
    }

    public Pyrometer findById(Integer id) {
        return Pyrometer.toModel(pyrometerRepository.findById(id).get());
    }

    public Pyrometer findByName(String name) {
        return Pyrometer.toModel(pyrometerRepository.findByName(name));
    }

    public Pyrometer findByPort(String port) {
        return Pyrometer.toModel(pyrometerRepository.findByPort(port));
    }

    public Integer deleteById(Integer id) {
        if (pyrometerRepository.existsById(id)) {
            pyrometerRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        pyrometerRepository.deleteAll();
        return 0;
    }

}
