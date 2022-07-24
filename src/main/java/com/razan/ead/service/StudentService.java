package com.razan.ead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.ead.model.Student;
import com.razan.ead.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private AdminService adminService;
	
	public Student createStudent(String fname, String lname, String email, String gender, String district, String city, String contact, String nameAppeared, 
			String indexNo, String faculty, int adminId) {
		
		Student student = new Student(fname, lname, email, gender, district, city, contact, nameAppeared, indexNo, faculty, adminService.getAdminById(adminId));
		return repository.save(student);
	}
	
	public Student getStudentById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Student> getAllStudent(){
		return repository.findAll();
	}
	
	public Student updateStudent(Student student) {
		Student existStudent = getStudentById(student.getId());
		
		if(existStudent != null) {
			existStudent.setCity(student.getCity());
			existStudent.setContact(student.getContact());
			existStudent.setDistrict(student.getDistrict());
			existStudent.setEmail(student.getEmail());
			existStudent.setFname(student.getFname());
			existStudent.setGender(student.getGender());
			existStudent.setId(student.getId());
			existStudent.setLname(student.getLname());
			existStudent.setIndexNo(student.getIndexNo());
			existStudent.setFaculty(student.getFaculty());
			
			repository.save(existStudent);
			return existStudent;
		}
		return null;
	}
	
	public void deleteStudent(int id) {
		repository.deleteById(id);
	}
	
	public Student getStudentByIndexNo(String indexNo) {
		return repository.findByIndexNo(indexNo).get(0);
	}
}
