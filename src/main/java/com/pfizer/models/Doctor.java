package com.pfizer.models;

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
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long doctor_id;
	
	private String name;
	private String city;
	private long phone_no;
	
	@OneToMany(mappedBy = "doctor")
	private Set<Bill> bills;
}
