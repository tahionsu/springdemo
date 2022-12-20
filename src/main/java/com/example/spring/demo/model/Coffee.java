package com.example.spring.demo.model;

import com.example.spring.demo.entity.CoffeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private UUID id;
    private String name;
    private String grind;

    public static Coffee toModel(CoffeeEntity entity) {
        Coffee coffee = new Coffee();

        coffee.setId(entity.getId());
        coffee.setName(entity.getName());
        coffee.setGrind(entity.getGrind());

        return coffee;
    }

}
