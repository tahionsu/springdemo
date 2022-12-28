package com.example.spring.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "subject_name")
    private String subjectName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return 32;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
