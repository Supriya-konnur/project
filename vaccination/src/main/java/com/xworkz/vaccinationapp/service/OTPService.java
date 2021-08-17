package com.xworkz.vaccinationapp.service;

public interface OTPService {

	public boolean validateAndGenerateOTP(String email);

	public boolean validateAndVerifyOTP(String password);

}
