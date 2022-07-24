package com.razan.ead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.ead.model.Doctor;
import com.razan.ead.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repository;
	
	@Autowired
	private AdminService adminService;
	
	public Doctor createDoctor(String fname, String lname, String email, String gender, String district, String city, String contact, String nameAppeared, int adminId) {
		
		Doctor doctor = new Doctor(fname, lname, email, gender, district, city, contact, nameAppeared, adminService.getAdminById(adminId));
		return repository.save(doctor);
	}
	
	public Doctor getDoctorById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Doctor> getAllDoctor(){
		return repository.findAll();
	}
	
	public Doctor updateDoctor(Doctor doctor) {
		Doctor existDoctor = getDoctorById(doctor.getId());
		
		if(existDoctor != null) {
			existDoctor.setCity(doctor.getCity());
			existDoctor.setContact(doctor.getContact());
			existDoctor.setDistrict(doctor.getDistrict());
			existDoctor.setEmail(doctor.getEmail());
			existDoctor.setFname(doctor.getFname());
			existDoctor.setGender(doctor.getGender());
			existDoctor.setId(doctor.getId());
			existDoctor.setLname(doctor.getLname());
			
			repository.save(existDoctor);
			return existDoctor;
		}
		return null;
	}
	
	public void deleteDoctor(int id) {
		repository.deleteById(id);
	}
}
