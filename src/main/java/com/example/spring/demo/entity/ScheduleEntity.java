package com.example.spring.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectEntity subject;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TeacherEntity teacher;
    @Column(name = "auditory")
    private String auditory;
    @Column(name = "date_time")
    private Date dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(subject, that.subject) && Objects.equals(teacher, that.teacher) && Objects.equals(auditory, that.auditory) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return 32;
    }

    @Override
    public String toString() {
        return "ScheduleEntity{" +
                "id=" + id +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", auditory='" + auditory + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
