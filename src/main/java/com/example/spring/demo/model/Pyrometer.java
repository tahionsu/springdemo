package com.example.spring.demo.model;

import com.example.spring.demo.entity.PyrometerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pyrometer {
    private Integer id;
    private String name;
    private String port;

    public static Pyrometer toModel(PyrometerEntity entity) {
        Pyrometer pyrometer = new Pyrometer();

        pyrometer.setId(entity.getId());
        pyrometer.setName(entity.getName());
        pyrometer.setPort(entity.getPort());

        return pyrometer;
    }

}
