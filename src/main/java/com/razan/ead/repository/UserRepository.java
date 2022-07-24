package com.razan.ead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.ead.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
