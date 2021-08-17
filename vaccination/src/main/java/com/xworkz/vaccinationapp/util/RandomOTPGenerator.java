package com.xworkz.vaccinationapp.util;

import java.util.Random;

public class RandomOTPGenerator {

	
	 public static String generateOTP(int len) {
	        int randomPin   =(int) (Math.random()*9000)+1000;
	        String otp  = String.valueOf(randomPin);
	        return otp;
	    }
	 
	 
//	 static char[] OTP(int len) {
//	        String numbers = "0123456789";    
//	        Random rndm_method = new Random();
//	  
//	        char[] otp = new char[len];
//	  
//	        for (int i = 0; i < len; i++) {
//	        	otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
//	        }
//	        return otp;
//	    }
		
}
