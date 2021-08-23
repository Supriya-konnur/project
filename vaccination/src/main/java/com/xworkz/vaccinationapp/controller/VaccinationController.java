package com.xworkz.vaccinationapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccinationapp.dto.VaccinationDTO;
import com.xworkz.vaccinationapp.service.VaccinationService;
import com.xworkz.vaccinationapp.service.VaccinationServiceImpl;

@Controller
@RequestMapping("/")
public class VaccinationController {

	Map<String, String> map = VaccinationServiceImpl.map;
	
	public VaccinationController() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	@Autowired
	 private VaccinationService service;
	
	@PostMapping("/signin.all")
	public ModelAndView saveEnrollDetails(@ModelAttribute VaccinationDTO vDTO) {
		
//		boolean res = service.validateAndSave(vDTO);
//		if(res) {
//			return new ModelAndView("welcomePage", "welcomemsg","In Welcome Page");
//		} else {
//
//			return new ModelAndView("homePage", "homemsg", "Something went wrong");
//		}
//		
		
		boolean result;

		try {
			result = this.service.registerServiceValidate(vDTO);
			System.out.println("validation result" + result);

			if (result) {
				this.service.save(vDTO);
				return new ModelAndView("VaccineLogin", "succesregistrationmessage",
						"Registration Success ....Please Login To Continue!!");

			} else if (!map.get("name").isEmpty() && vDTO.getName().isEmpty()) {
				return new ModelAndView("register", "namemsg", map.get("name"));

			} else if (!map.get("email").isEmpty() && vDTO.getEmail().isEmpty()) {
				return new ModelAndView("register", "emailmsg", map.get("email"));

			} else if (!map.get("password").isEmpty() && vDTO.getPassword().isEmpty()) {
				return new ModelAndView("register", "passwordmsg", map.get("password"));

			} else if (!map.get("mobile").isEmpty() && vDTO.getPhone().isEmpty()) {
				return new ModelAndView("register", "phonemsg", map.get("mobile"));

			} else if (!map.get("gender").isEmpty() && vDTO.getGender() == null) {
				return new ModelAndView("register", "gendermsg", map.get("gender"));

			} else if (!map.get("type").isEmpty() && vDTO.getTypeOfVaccine().isEmpty()) {
				return new ModelAndView("register", "typemsg", map.get("type"));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

		
	}
}
