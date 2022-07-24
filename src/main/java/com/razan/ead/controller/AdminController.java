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
import org.springframework.web.bind.annotation.RestController;

import com.razan.ead.model.Admin;
import com.razan.ead.service.AdminService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/create-admin")
	public Admin createAdmin(@RequestBody Admin admin) {
		return service.createAdmin(admin);
	}
	
	@GetMapping("/get-admin/{id}")
	public Admin getAdminById(@PathVariable int id) {
		return service.getAdminById(id);
	}
	
	@GetMapping("/get-all-admin")
	public List<Admin> getAllAdmin(){
		return service.getAllAdmin();
	}
	
	@PutMapping("/update-admin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}
	
	@DeleteMapping("/delete-admin/{id}")
	public void deleteAdmin(@PathVariable int id) {
		service.deleteAdmin(id);
	}
}
