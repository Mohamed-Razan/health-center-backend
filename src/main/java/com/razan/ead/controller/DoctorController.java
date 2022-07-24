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

import com.razan.ead.model.Doctor;
import com.razan.ead.service.DoctorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	@PostMapping("/create-doctor")
	public Doctor createDoctor(@RequestParam String fname, @RequestParam String lname, @RequestParam String email, @RequestParam String gender, 
			@RequestParam String district, @RequestParam String city, @RequestParam String contact, @RequestParam String nameAppeared, @RequestParam int adminId) {
		return service.createDoctor(fname, lname, email, gender, district, city, contact, nameAppeared, adminId);
	}
	
	@GetMapping("/get-doctor/{id}")
	public Doctor getDoctorById(@PathVariable int id) {
		return service.getDoctorById(id);
	}
	
	@GetMapping("/get-all-doctor")
	public List<Doctor> getAllDoctor(){
		return service.getAllDoctor();
	}
	
	@PutMapping("/update-doctor")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return service.updateDoctor(doctor);
	}
	
	@DeleteMapping("/delete-doctor/{id}")
	public void deleteDoctor(@PathVariable int id) {
		service.deleteDoctor(id);
	}
}
