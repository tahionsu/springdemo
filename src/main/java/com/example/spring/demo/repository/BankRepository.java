package com.example.spring.demo.repository;

import com.example.spring.demo.entity.BankEntity;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<BankEntity, Integer> {
    BankEntity findByName(String name);
}
