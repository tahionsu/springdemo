package com.example.spring.demo.model;

import com.example.spring.demo.entity.BankEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private Integer id;
    private String name;

    public static Bank toModel(BankEntity entity) {
        Bank bank = new Bank();

        bank.setId(entity.getId());
        bank.setName(entity.getName());

        return bank;
    }

}
