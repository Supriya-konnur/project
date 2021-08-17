package com.xworkz.enrollapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.enrollapp.dao.StudentEnrollDAO;
import com.xworkz.enrollapp.dto.StudentEnrollDTO;
import com.xworkz.enrollapp.entity.StudentEnrollEntity;
import com.xworkz.enrollapp.util.StudentEnrollUtil;
@Service
public class StudentEnrollServiceImpl implements StrudentEnrollService {


	@Autowired
	private StudentEnrollDAO sDAO;
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@Override
	public boolean validateAndSave(StudentEnrollDTO sDTO) {
		System.out.println(sDTO);

		StudentEnrollEntity sEntity = new StudentEnrollEntity();
		
	
		BeanUtils.copyProperties(sDTO,sEntity );
		
		
		boolean result = sDAO.saveDetails(sEntity);
		if(result) {
			System.out.println("mail sending started");
			System.out.println(sDTO);
			
			SimpleMailMessage simpleMMessage=StudentEnrollUtil.setProperties(sDTO);
			mailSender.send(simpleMMessage);
			System.out.println("mail sending is done");			
			return true;
		}else {
			System.out.println("something went wrong , try again");
			return false;
		}
	}

}
