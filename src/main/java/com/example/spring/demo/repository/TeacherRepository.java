package com.example.spring.demo.repository;

import com.example.spring.demo.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface TeacherRepository extends CrudRepository<TeacherEntity, UUID>
{
    ArrayList<TeacherEntity> findByFirstName(String firstName);
    ArrayList<TeacherEntity> findByLastName(String lastName);
    ArrayList<TeacherEntity> findByPosition(String position);

}
