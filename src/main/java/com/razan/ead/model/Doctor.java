package com.razan.ead.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@PrimaryKeyJoinColumn
public class Doctor extends User {

	@ManyToOne
	private Admin admin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "doctor")
	private List<Prescription> prescriptions;

	public Doctor(String fname, String lname, String email, String gender, String district, String city, String contact,
			String nameAppeared, Admin admin) {
		super(fname, lname, email, gender, district, city, contact, nameAppeared);
		this.admin = admin;
	}

	public Doctor() {
		super();
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	
}


