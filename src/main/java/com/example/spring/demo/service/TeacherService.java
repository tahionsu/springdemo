package com.example.spring.demo.service;

import com.example.spring.demo.entity.TeacherEntity;
import com.example.spring.demo.model.Teacher;
import com.example.spring.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(@Autowired TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher registration(TeacherEntity teacher) {
        return Teacher.toModel(teacherRepository.save(teacher));
    }

    public ArrayList<Teacher> findAll() {
        ArrayList<Teacher> teachers = new ArrayList<>();

        for (TeacherEntity entity : teacherRepository.findAll()) {
            teachers.add(Teacher.toModel(entity));
        }

        return teachers;
    }

    public Teacher findById(UUID id) {
        return Teacher.toModel(teacherRepository.findById(id).get());
    }

    public ArrayList<Teacher> findByFirstName(String firstName) {
        ArrayList<Teacher> teachers = new ArrayList<>();

        for (TeacherEntity entity : teacherRepository.findByFirstName(firstName)) {
            teachers.add(Teacher.toModel(entity));
        }

        return teachers;
    }

    public ArrayList<Teacher> findByLastName(String lastName) {
        ArrayList<Teacher> teachers = new ArrayList<>();

        for (TeacherEntity entity : teacherRepository.findByLastName(lastName)) {
            teachers.add(Teacher.toModel(entity));
        }

        return teachers;
    }

    public ArrayList<Teacher> findByPosition(String position) {
        ArrayList<Teacher> teachers = new ArrayList<>();

        for (TeacherEntity entity : teacherRepository.findByPosition(position)) {
            teachers.add(Teacher.toModel(entity));
        }

        return teachers;
    }

    public Integer deleteById(UUID id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        teacherRepository.deleteAll();
        return 0;
    }
}
