package com.mitrai.studentDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrai.studentDemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	Student findByName(String name);
}
