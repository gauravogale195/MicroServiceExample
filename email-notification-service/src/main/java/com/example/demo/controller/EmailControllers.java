package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Email;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailControllers{
	
	@Autowired
	EmailService emailService;
	
	@PostMapping
	public String getEmailDetails(@RequestBody Email email){
		emailService.sendEmail(email);
		return "Success";
	}

}
