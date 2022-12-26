package com.example.spring.demo.service;

import com.example.spring.demo.entity.CustomerEntity;
import com.example.spring.demo.model.Customer;
import com.example.spring.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registration(CustomerEntity customer) {
        return Customer.toModel(customerRepository.save(customer));
    }

    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList<>();

        for (CustomerEntity entity : customerRepository.findAll()) {
            customers.add(Customer.toModel(entity));
        }

        return customers;
    }

    public Customer findById(UUID id) {
        return Customer.toModel(customerRepository.findById(id).get());
    }

    public Customer findByFirstName(String firstname) {
        return Customer.toModel(customerRepository.findByFirstName(firstname));
    }

    public Customer findByLastName(String lastname) {
        return Customer.toModel(customerRepository.findByLastName(lastname));
    }

    public Customer findByAge(Integer age) {
        return Customer.toModel(customerRepository.findByAge(age));
    }

    public Integer deleteById(UUID id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        customerRepository.deleteAll();
        return 0;
    }
}
