package com.pfizer.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pfizer.models.Patient;
import com.pfizer.repositories.PatientRepository;

@Controller
public class MainController {
	
	@Autowired
	PatientRepository patientRepository;
	
	@GetMapping("/")
	public String homePage() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	 
	@GetMapping("/patient")
	public String patientHomePage(Model model) {
		
		model.addAttribute("patient", new Patient());
		return "patient/patienthome";
	}
	
	@GetMapping("/patient/new")
	public String getAllPatientsPage(Model model) {
		
		return "patient/signup";
	}
	
	@PostMapping("/patient/add")
	public String postNewPatient(@ModelAttribute Patient patient) {
		
		patientRepository.save(patient);
		return "patient/all";
	}
	
	@GetMapping("/patient/all")
	public String allPatientsPage(@ModelAttribute Patient patient, Model model) {
		
		List<Patient> patients = (ArrayList<Patient>) patientRepository.findAll();
		
		model.addAttribute("patients", patients);
//		return new ResponseEntity<>(new Patient(
//				patient.getPatient_id(), 
//				patient.getFirst_name(), 
//				patient.getLast_name(), 
//				patient.getCity(),
//				patient.getCountry(),
//				patient.getPhoneNo(), 
//				patient.getDob(), 
//				patient.getPayments()), HttpStatus.OK);
		return "patient/all";
	}
	
	@GetMapping("/signup")
	public String signUpPage() {
		
		return "patient/signup";
	}
	
//	@GetMapping("/patients")
//	public String getAllPatients(@ModelAttribute("sample") Sample sample, Model model) {	
//
//		List<Sample> samples = (List<Sample>) sampleRepository.findAll();
//		model.addAttribute("samples", samples);
//		return "simple";
//	}
//	
//	@PostMapping("/patients")
//	public ResponseEntity<Sample> saveNewPatient(@ModelAttribute("sample") Sample sample, Model model) {
//		System.out.println(sample.getId()+"***********" +sample.getName());
//		sampleRepository.save(sample);
////		ModelAndView mv = new ModelAndView("simple");
//		
//		return new ResponseEntity<>(new Sample(sample.getId(), sample.getName(), sample.getPrice()), HttpStatus.OK);
//	}
	
}
