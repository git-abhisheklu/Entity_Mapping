package com.neosoft.Excel.reader.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teacher_mapping")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subject;
    private String email;
    private String phoneNumber;
    private String department;
    private LocalDate dateOfJoining;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subjects subjects;
}
