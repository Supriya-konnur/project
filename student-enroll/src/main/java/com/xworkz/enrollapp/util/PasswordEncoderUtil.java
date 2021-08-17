package com.xworkz.enrollapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

	public static String encodePassword(String rawPassword) {
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		return bcryptEncoder.encode(rawPassword);

	}

	public static boolean decodePassword(String rawPassword, String passwordFromDB) {
		BCryptPasswordEncoder bcryptDecoder = new BCryptPasswordEncoder();
		return bcryptDecoder.matches(rawPassword, passwordFromDB);

		
	}
}
