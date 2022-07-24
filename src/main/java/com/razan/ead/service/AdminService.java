package com.razan.ead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.ead.model.Admin;
import com.razan.ead.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	public Admin createAdmin(Admin admin) {
		return repository.save(admin);
	}
	
	public Admin getAdminById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Admin> getAllAdmin(){
		return repository.findAll();
	}
	
	public Admin updateAdmin(Admin admin) {
		Admin existAdmin = getAdminById(admin.getId());
		
		if(existAdmin != null) {
			existAdmin.setCity(admin.getCity());
			existAdmin.setContact(admin.getContact());
			existAdmin.setDistrict(admin.getDistrict());
			existAdmin.setEmail(admin.getEmail());
			existAdmin.setFname(admin.getFname());
			existAdmin.setGender(admin.getGender());
			existAdmin.setId(admin.getId());
			existAdmin.setLname(admin.getLname());
			
			repository.save(existAdmin);
			return existAdmin;
		}
		return null;
	}
	
	public void deleteAdmin(int id) {
		repository.deleteById(id);
	}
}
