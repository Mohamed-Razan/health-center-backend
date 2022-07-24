package com.razan.ead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.ead.model.Doctor;
import com.razan.ead.model.Prescription;
import com.razan.ead.model.Student;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

	public List<Prescription> findByDoctor(Doctor doctor);
	public List<Prescription> findByStudent(Student student);
}
