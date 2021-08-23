package com.xworkz.vaccinationapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccinationapp.service.OTPService;
import com.xworkz.vaccinationapp.service.OTPServiceImpl;
@Controller
@RequestMapping("/")
public class OTPController {

	
	
	public OTPController() {
		System.out.println(this.getClass().getSimpleName() +"object created");
	}
	
	
	@RequestMapping(value="/getotppage", method=RequestMethod.GET)
	public String getOTPPage() {
		System.out.println("invoked getOTP page");
		return "OTPPage";
		
	}
	
	@Autowired
	private OTPService otpService;
	
	Map<String, String> map = OTPServiceImpl.map;
	
	@PostMapping("/signin.all")
	public ModelAndView verifyOTPDetails(@RequestParam String otp) {
		boolean varifyotp;
		boolean verifyCheck;
		try {
			varifyotp = otpService.validateOTP(otp);
			if (varifyotp) {
				verifyCheck = this.otpService.verifyOTP(otp);
				if (verifyCheck) {
					return new ModelAndView("register", "msg", "OTP verified .Thank you!!!");
				} else {
					return new ModelAndView("OTPPage", "otpmsg", map.get("otpverify"));

				}

			} 
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	
	}
}
