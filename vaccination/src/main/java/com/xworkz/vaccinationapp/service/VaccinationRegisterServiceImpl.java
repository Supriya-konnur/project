package com.xworkz.vaccinationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccinationapp.dao.VaccinationRegistrationDAO;
import com.xworkz.vaccinationapp.util.PasswordEncoderUtil;
@Service
public class VaccinationRegisterServiceImpl implements VaccinationRegisterService {

	@Autowired
	VaccinationRegistrationDAO vaccinationRegistrationDAO;
	@Override
	public boolean validateAndGetDetails(String email, String passwordD) {

		String passwordFromDB;
		if (!email.isEmpty() && !passwordD.isEmpty()) {
				passwordFromDB = vaccinationRegistrationDAO.verifyEmail(email);
				boolean passwordCheck = PasswordEncoderUtil.decodePassword(passwordD, passwordFromDB);
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
