package com.neosoft.Excel.reader.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "teachers_subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;
    private Long lectureHours;

    @OneToOne(mappedBy = "subjects")
    private Teacher teacherEntity;
}
