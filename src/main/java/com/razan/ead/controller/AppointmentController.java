package com.razan.ead.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razan.ead.model.Appointment;
import com.razan.ead.service.AppointmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@PostMapping("/create-appointment")
	public Appointment createAppointment(@RequestParam int id, @RequestParam Date date) {
		System.out.println(id);
		return service.createAppointment(id, date);
	}
	
	@GetMapping("/get-all-appointment")
	public List<Appointment> getAllAppointment(){
		return service.getAllAppointment();
	}
	
	@GetMapping("/get-appointment-by-id/{id}")
	public Appointment getAppointmentById(@PathVariable int id) {
		return service.getAppointmentById(id);
	}
	
	@DeleteMapping("/delete-appointment/{id}")
	public void deleteAppointment(@PathVariable int id) {
		service.deleteAppointment(id);
	}
	
	@GetMapping("/get-appointment-by-student/{id}")
	public List<Appointment> getAppointmentByStudent(@PathVariable int id){
		return service.getAppointmentByStudent(id);
	}
	
	@PutMapping("/update-appointment")
	public Appointment updateAppointment(@RequestParam int id, @RequestParam Time time, @RequestParam String status) {
		return service.updateAppointment(id, time, status);
	}
}
