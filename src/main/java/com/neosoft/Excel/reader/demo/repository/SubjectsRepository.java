package com.neosoft.Excel.reader.demo.repository;

import com.neosoft.Excel.reader.demo.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subjects,Long> {
}
