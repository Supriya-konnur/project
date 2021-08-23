package com.xworkz.vaccinationapp.service;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccinationapp.dao.OTPDAO;
import com.xworkz.vaccinationapp.util.RandomOTPGenerator;
import com.xworkz.vaccinationapp.util.VaccinationMailDispUtil;

@Service
public class OTPServiceImpl implements OTPService {

	@Autowired
	VaccinationMailDispUtil vmdUtill;
	

	@Autowired
	OTPDAO otpDAO;
	
	public static Map<String, String> map = new HashMap<String, String>();

	String userOTP;
	
	@Override
	public boolean validateEmail(String email) {
//		if (email != null && !email.isEmpty()) {
//			return true;
//		} else {
//			return false;
//		}
		userOTP = RandomOTPGenerator.generateOTP(4);
		boolean flag = false;
		if (email != null && !email.isEmpty()) {
			flag = true;

		} else {
			map.put("email", "*Email field cannot be empty!!!!");
		}
		return flag;
	}

	@Override
	public boolean sendOTP(String email) {
		vmdUtill.properties(email, "OTP for registration",
				"verify you otp in registration page :" + userOTP);
		return false;
	}

	@Override
	public boolean validateOTP(String otp) {
		boolean flag = false;
		if (otp != null && !otp.isEmpty()) {
			flag = true;

		} else {
			map.put("otpvalidate", "*OTP field cannot be empty!!!!");
		}
		return flag;

	}

	@Override
	public boolean verifyOTP(String otp) {
		boolean flag = false;
		if (otp.equals(userOTP)) {
			flag = true;
		} else {

			map.put("otpverify", "*Incorrect otp!!!!");
		}
		return flag;
		
		
	}

	@Override
	public boolean verifyEmailfromDB(String email) {

		String emailFromDB;
		
			emailFromDB = otpDAO.verifyEmail(email);
			if (emailFromDB != null && emailFromDB.equals(email)) {
				return true;

			}
		return false;
		
		
	}

}
