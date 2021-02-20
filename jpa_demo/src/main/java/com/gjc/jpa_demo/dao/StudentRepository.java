package com.gjc.jpa_demo.dao;

import com.gjc.jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {



}
