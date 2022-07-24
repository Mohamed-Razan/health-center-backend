package com.razan.ead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.ead.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByIndexNo(String indexNo);
	

}
