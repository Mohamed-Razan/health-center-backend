package com.razan.ead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.razan.ead.model.User;
import com.razan.ead.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/get-all-user")
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("get-user-by-id/{id}")
	public User getUser(@PathVariable int id) {
		return service.getUser(id);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}
}
