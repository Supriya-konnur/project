package com.xworkz.enrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.enrollapp.service.StudentLoginService;

@Controller
@RequestMapping("/")
public class StudentLoginController {

	public StudentLoginController() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	
	@Autowired
	StudentLoginService stdLoginService;

	@PostMapping("/login.all")
	
	public ModelAndView verifyLoginDetails(@RequestParam String email, @RequestParam String password) {
		boolean passwordDetails;
		passwordDetails = stdLoginService.validateAndGetLogInDetails(email, password);
		if (passwordDetails) {
			return new ModelAndView("StudentHome", "homemsg", "In home page");
		} else {
			return new ModelAndView("StudentLogin", "msgg", "Invalid EmailId or Password");

		}
	}
}
