package com.example.spring.demo.service;

import com.example.spring.demo.entity.ScheduleEntity;
import com.example.spring.demo.model.Schedule;
import com.example.spring.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(@Autowired ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule registration(ScheduleEntity schedule) {
        return Schedule.toModel(scheduleRepository.save(schedule));
    }

    public ArrayList<Schedule> findAll() {
        ArrayList<Schedule> teachers = new ArrayList<>();

        for (ScheduleEntity entity : scheduleRepository.findAll()) {
            teachers.add(Schedule.toModel(entity));
        }

        return teachers;
    }

    public Schedule findById(UUID id) {
        return Schedule.toModel(scheduleRepository.findById(id).get());
    }

    public ArrayList<Schedule> findByAuditory(String auditory) {
        ArrayList<Schedule> schedules = new ArrayList<>();

        for (ScheduleEntity entity : scheduleRepository.findByAuditory(auditory)) {
            schedules.add(Schedule.toModel(entity));
        }

        return schedules;
    }

    public ArrayList<Schedule> findByDateTime(Date dateTime) {
        ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

        for (ScheduleEntity entity : scheduleRepository.findByDateTime(dateTime)) {
            scheduleArrayList.add(Schedule.toModel(entity));
        }

        return scheduleArrayList;
    }

    public Integer deleteById(UUID id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    public Integer deleteAll() {
        scheduleRepository.deleteAll();
        return 0;
    }
}
