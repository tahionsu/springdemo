package com.example.spring.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "algorithms")
public class AlgorithmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String modelName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlgorithmEntity that = (AlgorithmEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(modelName, that.modelName);
    }

    @Override
    public int hashCode() {
        return 32;
    }
}
