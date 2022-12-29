package com.example.spring.demo.repository;

import com.example.spring.demo.entity.SubjectEntity;
import com.example.spring.demo.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubjectRepository extends CrudRepository<SubjectRepository, UUID> {

    SubjectEntity findBySubjectName(String subjectName);

}
