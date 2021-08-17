package com.xworkz.vaccinationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccinationapp.util.RandomOTPGenerator;
import com.xworkz.vaccinationapp.util.VaccinationMailDispUtil;

@Service
public class OTPServiceImpl implements OTPService {

	@Autowired
	VaccinationMailDispUtil vmdUtill;
	String userOTP;
	@Override
	public boolean validateAndGenerateOTP(String email) {

		 userOTP= RandomOTPGenerator.generateOTP(4);
		if(email != null) {
		vmdUtill.properties(email, userOTP, email);
		return true;
		}
		else {
		return false;
	}
}

	@Override
	public boolean validateAndVerifyOTP(String password) {

		if (password.equals(userOTP)) {
			return true;
		} else {

			return false;
		}
	}

}
