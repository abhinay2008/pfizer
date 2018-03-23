package com.pfizer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfizer.models.Patient;
import com.pfizer.repositories.PatientRepository;

@Service("patientService")
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		
		patientRepository.findAll()
			.forEach(patients::add);
		
		return patients;
	}
	
//	public Patient findPatientById(Long id) {
//		return patientRepository.findById(id);
//	}
	
	public void savePatient(Patient patient) {
		patientRepository.save(patient);
	}
}
