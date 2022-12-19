package com.example.spring.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiments")
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "algorithm_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AlgorithmEntity algorithm;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pyrometer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PyrometerEntity pyrometer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperimentEntity that = (ExperimentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(algorithm, that.algorithm) && Objects.equals(pyrometer, that.pyrometer);
    }

    @Override
    public int hashCode() {
        return 32;
    }
}
