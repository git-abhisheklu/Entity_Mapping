package com.neosoft.Excel.reader.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neosoft.Excel.reader.demo.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
