package com.neosoft.Excel.reader.demo.service;

import com.neosoft.Excel.reader.demo.entity.Subjects;
import com.neosoft.Excel.reader.demo.entity.Teacher;
import com.neosoft.Excel.reader.demo.repository.TeacherRepository;
import com.neosoft.Excel.reader.demo.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectsRepository subjectRepository;

    public void addTeacher(Teacher teacher) {

        if (teacher.getSubject() != null) {
            subjectRepository.save(teacher.getSubjects());
        }

        teacherRepository.save(teacher);
    }

    public Optional<Teacher> getTeacherByID(Long id) {
        return teacherRepository.findById(id);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Boolean updateTeacherById(Long id, Teacher updatedData) {
        Optional<Teacher> existingTeacherOpt = teacherRepository.findById(id);

        if (existingTeacherOpt.isPresent()) {
            Teacher existingTeacher = existingTeacherOpt.get();
            existingTeacher.setName(updatedData.getName());
            existingTeacher.setEmail(updatedData.getEmail());

            // Update subject if provided
            if (updatedData.getSubject() != null) {
                Subjects existingSubject = existingTeacher.getSubjects();
                if (existingSubject == null) {
                    // New subject case
                    subjectRepository.save(updatedData.getSubjects());
                    existingTeacher.setSubject(updatedData.getSubject());
                } else {
                    // Update existing subject details
//                    existingSubject.setName(updatedData.getSubject().getName());
                    existingSubject.setSubjectName(updatedData.getSubject());
                    subjectRepository.save(existingSubject);
                }
            }

            teacherRepository.save(existingTeacher);
            return true;
        }
        return false;
    }

    public void deleteTeacher( Long id ) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if( teacher.isPresent() ) {
            teacherRepository.deleteById(id);
        }
    }
}
