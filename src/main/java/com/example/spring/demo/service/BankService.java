package com.example.spring.demo.service;

import com.example.spring.demo.entity.BankEntity;
import com.example.spring.demo.model.Bank;
import com.example.spring.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(@Autowired BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank registration(BankEntity bank) {
        return Bank.toModel(bankRepository.save(bank));
    }

    public ArrayList<Bank> findAll() {
        ArrayList<Bank> banks = new ArrayList<>();

        for (BankEntity entity : bankRepository.findAll()) {
            banks.add(Bank.toModel(entity));
        }

        return banks;
    }

    public Bank findById(Integer id) {
        return Bank.toModel(bankRepository.findById(id).get());
    }

    public Bank findByName(String name) {
        return Bank.toModel(bankRepository.findByName(name));
    }

    public Integer deleteById(Integer id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        bankRepository.deleteAll();
        return 0;
    }

}
