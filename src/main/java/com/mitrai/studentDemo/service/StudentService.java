package com.mitrai.studentDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrai.studentDemo.entity.Student;
import com.mitrai.studentDemo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo; 
	
	//Post
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> saveStudents(List<Student> students) {
		return studentRepo.saveAll(students);
	}
	
	//Get
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}
	
	public Student getStudentById(int studentId){
		return studentRepo.findById(studentId).orElse(null);
	}
	
	public Student getStudentByName(String name){
		return studentRepo.findByName(name);
	}
	
	//Delete
	public Student deleteStudent(int studentId){
		Student ret = studentRepo.findById(studentId).orElse(null);
		studentRepo.deleteById(studentId);
		return ret;
	}
	
	//Update
	public Student updateStudent(Student student){
		Student currentStudent = studentRepo.findById(student.getStudentId()).orElse(null);
		currentStudent.setName(student.getName());
		currentStudent.setScore(student.getScore());
		return studentRepo.save(currentStudent); 
	}
	
	
}
