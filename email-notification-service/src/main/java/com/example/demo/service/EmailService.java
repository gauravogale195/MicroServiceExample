package com.example.demo.service;

import com.example.demo.model.Email;

public interface EmailService {
	
	public String getNotificationType(Email email);
	
	public void sendEmail(Email email);
	
	

}
