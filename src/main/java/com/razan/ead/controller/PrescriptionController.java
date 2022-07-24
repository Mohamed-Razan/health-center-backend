package com.razan.ead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razan.ead.model.Prescription;
import com.razan.ead.service.PrescriptionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PrescriptionController {

	@Autowired
	private PrescriptionService service;
	
	@PostMapping("/create-prescription")
	public Prescription createPrescription(@RequestParam String studentIndexNo, @RequestParam int doctorId, @RequestParam String symptoms, 
			@RequestParam String disease, @RequestParam String medicine) {
		return service.createPrescription(studentIndexNo, doctorId, symptoms, disease, medicine);
	}
	
	@GetMapping("/get-all-prescription")
	public List<Prescription> getAllPrescription(){
		return service.getAllPrescription();
	}
	
	@GetMapping("/get-prescription-by-id/{id}")
	public Prescription getPrescriptionById(@PathVariable int id) {
		return service.getPrescriptionById(id);
	}
	
	@GetMapping("/get-prescription-by-doctor/{id}")
	public List<Prescription> getPrescriptionByDoctor(@PathVariable int id){
		return service.getPrescriptionByDoctor(id);
	}
	
	@DeleteMapping("/delete-prescription/{id}")
	public void deletePrescription(@PathVariable int id) {
		service.deletePrescription(id);
	}
	
	@GetMapping("/get-prescription-by-student/{id}")
	public List<Prescription> getPrescriptionByStudent(@PathVariable int id){
		return service.getPrescriptionByStudent(id);
	}
}
