package com.xworkz.vaccinationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccinationapp.dto.VaccinationDTO;
import com.xworkz.vaccinationapp.service.VaccinationService;

@Controller
@RequestMapping("/")
public class VaccinationController {

	public VaccinationController() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	@Autowired
	 private VaccinationService service;
	
	@PostMapping("/signin.all")
	public ModelAndView saveEnrollDetails(@ModelAttribute VaccinationDTO vDTO) {
		
		boolean res = service.validateAndSave(vDTO);
		if(res) {
			return new ModelAndView("welcomePage", "welcomemsg","In Welcome Page");
		} else {

			return new ModelAndView("homePage", "homemsg", "Something went wrong");
		}
		
		
	}
}
