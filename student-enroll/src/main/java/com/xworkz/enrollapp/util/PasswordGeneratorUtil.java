package com.xworkz.enrollapp.util;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGeneratorUtil {

	
	 static char[] passwordGen(int len) {
	        String Upper_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	        String symbols = "!@#$%^&*_=+-/.?<>)";
	  
	  
	        String values = Upper_chars + Small_chars + numbers + symbols;
	  
	        Random rndm_method = new Random();
	  
	        char[] password = new char[len];
	  
	        for (int i = 0; i < len; i++)
	        {
	            password[i] = values.charAt(rndm_method.nextInt(values.length()));
	  
	        }
	        return password;
	    }


}
