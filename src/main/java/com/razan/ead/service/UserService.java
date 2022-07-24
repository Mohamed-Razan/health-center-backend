package com.razan.ead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.ead.model.User;
import com.razan.ead.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUser(){
		return repository.findAll();
	}
	
	public User getUser(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteUser(int id) {
		repository.deleteById(id);
	}
}
