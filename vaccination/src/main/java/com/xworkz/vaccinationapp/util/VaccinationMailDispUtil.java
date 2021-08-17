package com.xworkz.vaccinationapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class VaccinationMailDispUtil {
	
	@Autowired
	private JavaMailSender mailSender;

	public void properties(String mail, String subject, String text) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(mail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);

		mailSender.send(simpleMailMessage);

	}

}
