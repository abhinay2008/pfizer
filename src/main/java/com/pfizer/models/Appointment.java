package com.pfizer.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
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
public class Appointment {
	
	@Id
	private long appointment_id;
	
	private LocalDate doa;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	public void setDoa(String doa) {
		
		this.doa = LocalDate.parse(doa, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
}
