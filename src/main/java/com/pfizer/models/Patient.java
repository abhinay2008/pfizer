package com.pfizer.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long patient_id;
	
	private String first_name;
	private String last_name;
	private String city;
	private String country;
	private long phone_no;
	private LocalDate dob;
	
	@OneToMany(mappedBy = "patient")
	private Set<Payment> payments;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;
	
	public void setDob(String dob) {
		this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
	
}
