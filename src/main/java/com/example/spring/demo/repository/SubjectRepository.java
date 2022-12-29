package com.example.spring.demo.repository;

import com.example.spring.demo.entity.SubjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubjectRepository extends CrudRepository<SubjectEntity, UUID> {

    SubjectEntity findBySubjectName(String subjectName);

}
