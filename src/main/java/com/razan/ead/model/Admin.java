package com.razan.ead.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@PrimaryKeyJoinColumn
public class Admin extends User {

	@JsonIgnore
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Doctor> doctors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Student> students;

	public Admin(String fname, String lname, String email, String gender, String district, String city, String contact,
			String nameAppeared) {
		super(fname, lname, email, gender, district, city, contact, nameAppeared);
	}

	public Admin() {
		super();
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}

