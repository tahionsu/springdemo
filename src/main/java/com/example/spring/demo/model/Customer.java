package com.example.spring.demo.model;

import com.example.spring.demo.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private UUID id;

    private Integer age;
    private String firstname;
    private String lastname;

    public static Customer toModel(CustomerEntity entity) {
        Customer customer = new Customer();

        customer.setId(entity.getId());
        customer.setAge(entity.getAge());
        customer.setFirstname(entity.getFirstname());
        customer.setLastname(entity.getLastname());

        return customer;
    }

}
