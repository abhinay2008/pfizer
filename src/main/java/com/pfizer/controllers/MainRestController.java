//package com.pfizer.controllers;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.pfizer.models.Patient;
//import com.pfizer.services.PatientService;
//
//@RestController
//public class MainRestController {
//
//	@Autowired
//	private PatientService patientService;
//
//	@GetMapping("/patients")
//	public List<Patient> getPatient() {
//		
//		return patientService.getAllPatients();
//	}
//	
//	@PostMapping("/patient/{id}")
//	public void addPatient(@RequestBody Patient patient) {
//		
//		patientService.savePatient(patient);
//	}
//}
