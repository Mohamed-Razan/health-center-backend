package com.razan.ead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.ead.model.Doctor;
import com.razan.ead.model.Prescription;
import com.razan.ead.model.Student;
import com.razan.ead.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository repository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DoctorService doctorService;
	
	public Prescription createPrescription(String studentIndexNo, int doctorId, String symptoms, String disease, String medicine) {
		
		Student student = studentService.getStudentByIndexNo(studentIndexNo);
		Doctor doctor = doctorService.getDoctorById(doctorId);
		
		Prescription prescription = new Prescription(symptoms, disease, medicine, student, doctor);
		
		return repository.save(prescription);
	}
	
	public List<Prescription> getAllPrescription(){
		return repository.findAll();
	}
	
	public Prescription getPrescriptionById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Prescription> getPrescriptionByDoctor(int id){
		return repository.findByDoctor(doctorService.getDoctorById(id));
	}
	
	public void deletePrescription(int id) {
		repository.deleteById(id);
	}
	
	public List<Prescription> getPrescriptionByStudent(int id) {
		return repository.findByStudent(studentService.getStudentById(id));
	}
}
