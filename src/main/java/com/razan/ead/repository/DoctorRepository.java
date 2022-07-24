package com.razan.ead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.ead.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
