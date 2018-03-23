package com.pfizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long bill_no;
	
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
}
