package com.example.demo.service;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.model.Email;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender javaMailSender;

	@Autowired
	TemplateEngine templateEngine;

	@Autowired
	MailProperties mailProperties;

	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	@Override
	public String getNotificationType(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Async
	public void sendHtmlMail(String to, String subject, String templateName, Context context)
			throws MessagingException, javax.mail.MessagingException {
		MimeMessage mail = javaMailSender.createMimeMessage();
		String body = templateEngine.process(templateName, context);
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(to);
		helper.setFrom("any@outlook.com"); //set from address same as in prop file(username)
		helper.setSubject(subject);
		helper.setText(body, true);
		javaMailSender.send(mail);

	}

	@Override
	public void sendEmail(Email email) {
		Context context = new Context();
		context.setVariable("UserName", email.getEmailAddress());
		context.setVariable("Subject", email.getSubject());

		try {
			sendHtmlMail(email.getEmailAddress(), email.getSubject(), "email-notification", context);
		} catch (MessagingException e) {
			//log.error("error in  sendForgotPasswordEmail" + e);
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
