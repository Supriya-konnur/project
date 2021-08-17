package com.xworkz.vaccinationapp.service;

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

	@Autowired
	private VaccinationDAO vDAO;
	
	@Autowired
	VaccinationMailDispUtil vDisputill;
	
	@Override
	public boolean validateAndSave(VaccinationDTO vDTO) {

		VaccinationEntity vaccinationEntity = new VaccinationEntity();
		String pwd = vDTO.getPassword();
		
		
		String passwordEncoded = PasswordEncoderUtil.encodePassword(pwd);
		BeanUtils.copyProperties(vDTO, vaccinationEntity);
		vaccinationEntity.setPassword(passwordEncoded);
		
		boolean res = vDAO.saveDetails(vaccinationEntity);
		if(res) {
			vDisputill.properties(vDTO.getEmail(), vDTO.getName(), vDTO.getPassword());
			return true;
		}
		else {
			System.out.println("something went wrong , try again");
			return false;
		}
		
	}

}
