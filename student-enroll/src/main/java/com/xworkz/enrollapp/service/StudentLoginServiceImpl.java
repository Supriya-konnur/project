package com.xworkz.enrollapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.enrollapp.dao.StudentLoginDAO;
import com.xworkz.enrollapp.util.PasswordEncoderUtil;
@Service
public class StudentLoginServiceImpl implements StudentLoginService {

	@Autowired
	private StudentLoginDAO sLogDAO;
	
	@Override
	public boolean validateAndGetLogInDetails(String email, String passwordDetails) {

		String passwordFromDB;
		if (!email.isEmpty() && !passwordDetails.isEmpty()) {
				passwordFromDB = sLogDAO.verifyEmail(email);
				boolean passwordCheck = PasswordEncoderUtil.decodePassword(passwordDetails, passwordFromDB);
				if (passwordCheck) {
					return true;
				} else {
					return false;

				}
			
		} else {
			return false;
		}
		
	}

}
