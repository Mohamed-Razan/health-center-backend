package com.razan.ead.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class Prescription {

	@Id
	@GeneratedValue
	private int id;
	private String symptoms;
	private String disease;
	private String medicine;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Doctor doctor;

	public Prescription(String symptoms, String disease, String medicine, Student student, Doctor doctor) {
		super();
		this.symptoms = symptoms;
		this.disease = disease;
		this.medicine = medicine;
		this.student = student;
		this.doctor = doctor;
	}

	public Prescription() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
