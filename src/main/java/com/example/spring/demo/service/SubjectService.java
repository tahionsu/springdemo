package com.example.spring.demo.service;

import com.example.spring.demo.entity.SubjectEntity;
import com.example.spring.demo.model.Subject;
import com.example.spring.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(@Autowired SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject registration(SubjectEntity subject) {
        return Subject.toModel(subjectRepository.save(subject));
    }

    public ArrayList<Subject> findAll() {
        ArrayList<Subject> teachers = new ArrayList<>();

        for (SubjectEntity entity : subjectRepository.findAll()) {
            teachers.add(Subject.toModel(entity));
        }

        return teachers;
    }

    public Subject findById(UUID id) {
        return Subject.toModel(subjectRepository.findById(id).get());
    }

    public Subject findBySubjectName(String subjectName) {
        return Subject.toModel(subjectRepository.findBySubjectName(subjectName));
    }

    public Integer deleteById(UUID id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        subjectRepository.deleteAll();
        return 0;
    }
}
