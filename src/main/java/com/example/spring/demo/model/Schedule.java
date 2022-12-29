package com.example.spring.demo.model;

import com.example.spring.demo.entity.ScheduleEntity;
import com.example.spring.demo.entity.SubjectEntity;
import com.example.spring.demo.entity.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private UUID id;
    private SubjectEntity subject;
    private TeacherEntity teacher;
    private String auditory;
    private Date dateTime;

    public static Schedule toModel(ScheduleEntity entity) {
        Schedule schedule = new Schedule();

        schedule.setId(entity.getId());
        schedule.setSubject(entity.getSubject());
        schedule.setTeacher(entity.getTeacher());
        schedule.setAuditory(entity.getAuditory());
        schedule.setDateTime(entity.getDateTime());

        return schedule;
    }
}
