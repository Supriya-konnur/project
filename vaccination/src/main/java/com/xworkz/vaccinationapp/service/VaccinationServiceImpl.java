package com.xworkz.vaccinationapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccinationapp.dao.VaccinationDAO;
import com.xworkz.vaccinationapp.dto.VaccinationDTO;
import com.xworkz.vaccinationapp.entity.VaccinationEntity;
import com.xworkz.vaccinationapp.util.PasswordEncoderUtil;
import com.xworkz.vaccinationapp.util.VaccinationMailDispUtil;
@Service
public class VaccinationServiceImpl implements VaccinationService {

	public static Map<String, String> map = new HashMap<String, String>();
	
	@Autowired
	private VaccinationDAO vDAO;
	
	@Autowired
	VaccinationMailDispUtil vDisputill;

	@Override
	public boolean registerServiceValidate(VaccinationDTO vdto) {
		boolean flag = false;

		if (vdto.getName() != null && !vdto.getName().isEmpty() && vdto.getEmail() != null
				&& !vdto.getEmail().isEmpty() && vdto.getPhone() != null
				&& !vdto.getPhone().isEmpty() && vdto.getPassword() != null
				&& !vdto.getPassword().isEmpty() && vdto.getTypeOfVaccine() != null
				&& !vdto.getTypeOfVaccine().isEmpty() && vdto.getGender() != null
				&& !vdto.getGender().isEmpty()) {
			flag = true;

		} else {
			map.put("name", "*Name field cant be empty!!!!");
			map.put("email", "*Email field cant be empty!!!!");
			map.put("password", "*Password field cant be empty!!!!");
			map.put("phone", "*phone field cant be empty!!!!");
			map.put("gender", "*Gender cant be empty!!!!");
			map.put("type", "*Type of field cant be empty!!!!");

		}
		return flag;
	}

	@Override
	public boolean save(VaccinationDTO vdto) {
		
		VaccinationEntity vaccinationEntity = new VaccinationEntity();
		
		
		String userPassword = vdto.getPassword();
		System.out.println("password user entered " + vdto.getPassword());
		String passwordEncoded = PasswordEncoderUtil.encodePassword(userPassword);
		System.out.println("password encoded " + passwordEncoded);
		BeanUtils.copyProperties(vdto, vaccinationEntity);
		vaccinationEntity.setPassword(passwordEncoded);

		boolean result;
		try {
			result = vDAO.saveDetails(vaccinationEntity);

			if (result) {
				System.out.println("mail sending started");
				System.out.println(vdto);

				vDisputill.properties(vdto.getEmail(), "Sign in Confirmation",
						"Thank you for enrolling " + vdto.getName()
								+ " Please use the provided password to login : " + vdto.getPassword());

				System.out.println("mail sending is done");
				return true;
			} else {
				System.out.println("something went wrong , try again");
				return false;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		

	}
	
//	@Override
//	public boolean validateAndSave(VaccinationDTO vDTO) {
//
//		VaccinationEntity vaccinationEntity = new VaccinationEntity();
//		String pwd = vDTO.getPassword();
//		
//		
//		String passwordEncoded = PasswordEncoderUtil.encodePassword(pwd);
//		BeanUtils.copyProperties(vDTO, vaccinationEntity);
//		vaccinationEntity.setPassword(passwordEncoded);
//		
//		boolean res = vDAO.saveDetails(vaccinationEntity);
//		if(res) {
//			vDisputill.properties(vDTO.getEmail(), vDTO.getName(), vDTO.getPassword());
//			return true;
//		}
//		else {
//			System.out.println("something went wrong , try again");
//			return false;
//		}
//		
	}


