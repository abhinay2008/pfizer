package com.pfizer.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pfizer.models.Patient;
import com.pfizer.models.Sample;
import com.pfizer.repositories.PatientRepository;
import com.pfizer.repositories.SampleRepository;

@Controller
public class MainController {
	
	@Autowired
	SampleRepository sampleRepository;
	
	@GetMapping("/")
	public String homePage() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	 
	@GetMapping("/patient")
	public String patientHomePage(Model model) {
		
		model.addAttribute("patient", new Patient());
		return "patient/patienthome";
	}
	
	@PostMapping("/patient")
	public String postNewPatient(@ModelAttribute Patient patient) {

		return "result";
	}
	
//	@GetMapping("/result") 
//	public String getResutlspage() {
//		return "result";
//	}
	
	@GetMapping("/signup")
	public String signUpPage() {
		
		return "signup";
	}
	
	@GetMapping("/patients")
	public String getAllPatients(@ModelAttribute("sample") Sample sample, Model model) {	

		List<Sample> samples = (List<Sample>) sampleRepository.findAll();
		model.addAttribute("samples", samples);
		return "simple";
	}
	
	@PostMapping("/patients")
	public ResponseEntity<Sample> saveNewPatient(@ModelAttribute("sample") Sample sample, Model model) {
		System.out.println(sample.getId()+"***********" +sample.getName());
		sampleRepository.save(sample);
//		ModelAndView mv = new ModelAndView("simple");
		
		return new ResponseEntity<>(new Sample(sample.getId(), sample.getName(), sample.getPrice()), HttpStatus.OK);
	}
	
}
