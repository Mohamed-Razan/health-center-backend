package com.razan.ead.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.ead.model.Appointment;
import com.razan.ead.model.Student;
import com.razan.ead.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository repository;
	
	@Autowired
	private StudentService studentService;
	
	public Appointment createAppointment(int id, Date date) {
		
		Appointment appointment = new Appointment(date, studentService.getStudentById(id));
		return repository.save(appointment);
	}
	
	public List<Appointment> getAllAppointment() {
		return repository.findAll();
	}
	
	public Appointment getAppointmentById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteAppointment(int id) {
		repository.deleteById(id);
	}
	
	public List<Appointment> getAppointmentByStudent(int id) {
		Student student = studentService.getStudentById(id);
		
		if(student != null) {
			return repository.findByStudent(student);
		}
		return null;
	}
	
	public Appointment updateAppointment(int id, Time time, String status) {
		
		Appointment existAppointment = getAppointmentById(id);
		
		if(existAppointment != null) {
			existAppointment.setTime(time);
			existAppointment.setStatus(status);
			repository.save(existAppointment);
			return existAppointment;
		}
		return null;
	}
}
