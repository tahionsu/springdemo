package com.example.spring.demo.service;

import com.example.spring.demo.entity.BankEntity;
import com.example.spring.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BankService {
    private final BankRepository bankRepository;

    public BankService(@Autowired BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public BankEntity registration(BankEntity bank) {
        return bankRepository.save(bank);
    }

    public Iterable<BankEntity> findAll() {
        return bankRepository.findAll();
    }

    public BankEntity findById(Integer id) {
        return bankRepository.findById(id).get();
    }

    public BankEntity findByName(String name) {
        return bankRepository.findByName(name);
    }

    public Integer deleteById(Integer id) {
        bankRepository.deleteById(id);
        return id;
    }

    public Integer deleteAll() {
        bankRepository.deleteAll();
        return 0;
    }

    public boolean existById(Integer id) {
        return bankRepository.existsById(id);
    }

}
