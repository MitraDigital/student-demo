package com.mitrai.studentDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitrai.studentDemo.entity.Student;
import com.mitrai.studentDemo.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/api/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PostMapping("/api/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentService.saveStudents(students);
	}
	
	@GetMapping("/api/students")
	public List<Student> getAllStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("/api/studentById/{studentId}")
	public Student getStudentById(@PathVariable int studentId){
		return studentService.getStudentById(studentId);
	}
	
	@GetMapping("/api/say")
	public String hello(){
		return "hi there";
	}
	
	@GetMapping("/api/studentByName/{name}")
	public Student getStudentByName(@PathVariable String name){
		return studentService.getStudentByName(name);
	}

	@PutMapping("/api/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/api/deleteStudent/{studentId}")
	public Student deleteStudent(@PathVariable int studentId) {
		return studentService.deleteStudent(studentId);
	}
}
