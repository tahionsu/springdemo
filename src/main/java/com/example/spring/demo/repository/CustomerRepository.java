package com.example.spring.demo.repository;

import com.example.spring.demo.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {
    CustomerEntity findByFirstName(String firstname);

    CustomerEntity findByLastName(String lastname);

    ArrayList<CustomerEntity> findByAge(Integer age);

}
