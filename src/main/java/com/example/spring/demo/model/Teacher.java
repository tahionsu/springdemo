package com.example.spring.demo.model;

import com.example.spring.demo.entity.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private UUID id;
    private String firstName;
    private String lastName;
    private String position;

    public static Teacher toModel(TeacherEntity entity) {
        Teacher teacher = new Teacher();

        teacher.setId(entity.getId());
        teacher.setFirstName(entity.getFirstName());
        teacher.setLastName(entity.getLastName());
        teacher.setPosition(entity.getPosition());

        return teacher;
    }
}
