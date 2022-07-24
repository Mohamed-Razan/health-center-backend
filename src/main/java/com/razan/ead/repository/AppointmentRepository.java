package com.razan.ead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.ead.model.Appointment;
import com.razan.ead.model.Student;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> findByStudent(Student student);

}
