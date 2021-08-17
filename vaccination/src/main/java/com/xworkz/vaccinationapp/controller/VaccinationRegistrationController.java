package com.xworkz.vaccinationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccinationapp.service.VaccinationRegisterService;

@Controller
@RequestMapping("/")
public class VaccinationRegistrationController {

	public VaccinationRegistrationController() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	@Autowired
	VaccinationRegisterService vaccinationRegisterService;
	
	@PostMapping("/login.all")
	public ModelAndView verifyLoginDetails(@RequestParam String email, @RequestParam String password) {
		boolean passwordDetails=vaccinationRegisterService.validateAndGetDetails(email, password);
			if (passwordDetails) {
				return new ModelAndView("register", "msg", "Registration Successfull!!");
			} else {
				return new ModelAndView("homePage", "homemsg", "Invalid EmailId or Password");

			}
	}

}
