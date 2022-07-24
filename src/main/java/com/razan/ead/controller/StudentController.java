package com.razan.ead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razan.ead.model.Student;
import com.razan.ead.service.StudentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/create-student")
	public Student createStudent(@RequestParam String fname, @RequestParam String lname, @RequestParam String email, @RequestParam String gender, 
			@RequestParam String district, @RequestParam String city, @RequestParam String contact, @RequestParam String nameAppeared, 
			@RequestParam String indexNo, @RequestParam String faculty, @RequestParam int adminId) {
		return service.createStudent(fname, lname, email, gender, district, city, contact, nameAppeared, indexNo, faculty, adminId);
	}
	
	@GetMapping("/get-student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	@GetMapping("/get-all-student")
	public List<Student> getAllStudent(){
		return service.getAllStudent();
	}
	
	@PutMapping("/update-student")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/delete-student/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
	}
}
