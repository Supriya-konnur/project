package com.xworkz.enrollapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.xworkz.enrollapp.dto.StudentEnrollDTO;

@Component
public class StudentEnrollUtil {

	@Autowired
	private JavaMailSender mailSender;
	
		
		public void setProperties(String mail, String subject, String text) {

			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(mail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(text);
			mailSender.send(simpleMailMessage);

		}
		
}
