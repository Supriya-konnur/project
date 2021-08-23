package com.xworkz.vaccinationapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccinationapp.dao.VaccinationRegistrationDAO;
import com.xworkz.vaccinationapp.entity.VaccinationEntity;
import com.xworkz.vaccinationapp.util.PasswordEncoderUtil;
@Service
public class VaccinationRegisterServiceImpl implements VaccinationRegisterService {

	public static Map<String, String> map = new HashMap<>();

	
	@Autowired
	VaccinationRegistrationDAO vaccinationRegistrationDAO;

	@Override
	public boolean verifyRegistrationDetails(String email, String pwd) {

		boolean flag = false;
		if (!email.isEmpty() && email != null && !pwd.isEmpty() && pwd != null) {

			flag = true;
		} else {
			map.put("email", "*Enter your Email!!!!");
			map.put("password", "*Enter password!!!!");
		}

		return flag;
	}


}
