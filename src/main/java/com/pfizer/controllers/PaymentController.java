package com.pfizer.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfizer.models.Payment;
import com.pfizer.repositories.PaymentRepository;

@RestController
@RequestMapping(value = "/payments/api")
public class PaymentController {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@GetMapping("/all")
	public String getPayments() {
		
		List<Payment> payments = (ArrayList<Payment>) paymentRepository.findAll();
		
		return payments.toString();
	}
	
	@PostMapping("/payment")
	public void postNewPayments(@RequestBody Payment payment) {
		
		paymentRepository.save(payment);
	}
	
}
