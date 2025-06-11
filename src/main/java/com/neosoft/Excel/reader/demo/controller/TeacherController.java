package com.neosoft.Excel.reader.demo.controller;

import com.neosoft.Excel.reader.demo.entity.Teacher;
import com.neosoft.Excel.reader.demo.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/teachers")
@RestController
@AllArgsConstructor
public class TeacherController {

//    @Autowired
    private TeacherService teacher;

    @PostMapping("/add")
    public void addTeacher(@RequestBody Teacher t) { teacher.addTeacher(t);}

    @GetMapping("/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable Long id) {
        return teacher.getTeacherByID(id);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacher.getAllTeachers();
    }

    @PutMapping("/{id}")
    public String updateTeacherById(@PathVariable Long id,@RequestBody Teacher t)
    {
        Boolean bool=teacher.updateTeacherById(id, t);
    if(bool==true)
    {
        return "Teacher's record is updated";
    }
    return "Teacher is not found";
    }

    @RequestMapping("/{id}")
    public String deleteTeacherById(@PathVariable Long id)
    {
        teacher.deleteTeacher(id);
        return "Teacher is deleted";
    }
}
