package com.xworkz.enrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.enrollapp.dto.StudentEnrollDTO;
import com.xworkz.enrollapp.service.StrudentEnrollService;

@Controller
@RequestMapping("/")
public class StudentEnrollController {

	public StudentEnrollController() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	@Autowired
	private StrudentEnrollService stdService;
	
	@PostMapping("/signin.all")
	public ModelAndView saveEnrollDetails(@ModelAttribute StudentEnrollDTO sDTO) {
		
		boolean outcome = stdService.validateAndSave(sDTO);
		if(outcome) {
			
			return new ModelAndView("StudentLogin", "msgg","Congrats! enrollment is succesfull");
		}
		else {
			return new ModelAndView("StudentEnroll", "msg","Something went wrong");
	
		}
	}	
}
