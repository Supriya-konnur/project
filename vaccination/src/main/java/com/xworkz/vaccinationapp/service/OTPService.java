package com.xworkz.vaccinationapp.service;

public interface OTPService {

	public boolean validateEmail(String email);

	public boolean sendOTP(String email);

	public boolean validateOTP(String otp);

	public boolean verifyOTP(String otp);

	public boolean verifyEmailfromDB(String email);


}
