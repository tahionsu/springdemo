package com.example.spring.demo.repository;

import com.example.spring.demo.entity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, UUID> {

    ArrayList<ScheduleEntity> findByAuditory(String auditory);
    ArrayList<ScheduleEntity> findByDateTime(Date dateTime);

}
