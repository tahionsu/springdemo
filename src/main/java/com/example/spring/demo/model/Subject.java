package com.example.spring.demo.model;

import com.example.spring.demo.entity.SubjectEntity;
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
public class Subject {
    private UUID id;
    private String subjectName;

    Subject toModel(SubjectEntity entity) {
        Subject subject = new Subject();

        subject.setId(entity.getId());
        subject.setSubjectName(entity.getSubjectName());

        return subject;
    }
}
