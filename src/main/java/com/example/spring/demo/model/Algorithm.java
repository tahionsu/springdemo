package com.example.spring.demo.model;

import com.example.spring.demo.entity.AlgorithmEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Algorithm {
    private Integer id;
    private String name;

    public static Algorithm toModel(AlgorithmEntity entity) {
        Algorithm model = new Algorithm();

        model.setId(entity.getId());
        model.setName(entity.getModelName());

        return model;
    }

}
