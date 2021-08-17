package com.xworkz.enrollapp.util;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PasswordGeneratorUtil {

	private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
	private static final String DIGIT = "0123456789";
	private static final String OTHER_PUNCTUATION = "!@#&()–[{}]:;',?/*";
	private static final String OTHER_SYMBOL = "~$^+=<>";
	private static final String OTHER_SPECIAL = OTHER_PUNCTUATION + OTHER_SYMBOL;

	private static final String PASSWORD_ALLOW = CHAR_LOWERCASE + CHAR_UPPERCASE + DIGIT + OTHER_SPECIAL;

	private static SecureRandom random = new SecureRandom();

	public static String randomPasswordGenerator(int passwordLength) {
		return generateStrongPassword(passwordLength);
	}

	public static String generateStrongPassword(int passwordLength) {

		StringBuilder result = new StringBuilder(passwordLength);

		String strLowerCase = generateRandomString(CHAR_LOWERCASE, 1);
		result.append(strLowerCase);

		String strUppercaseCase = generateRandomString(CHAR_UPPERCASE, 1);
		result.append(strUppercaseCase);

		String strDigit = generateRandomString(DIGIT, 1);
		result.append(strDigit);

		String strSpecialChar = generateRandomString(OTHER_SPECIAL, 1);
		result.append(strSpecialChar);

		String strOther = generateRandomString(PASSWORD_ALLOW, passwordLength - 4);
		result.append(strOther);

		String password = result.toString();

		return password;
	}

	private static String generateRandomString(String input, int size) {

		if (input == null || input.length() <= 0)
			System.out.println("invalid input");
		if (size < 1)
			System.out.println("invalid size");

		StringBuilder result1 = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			int index = random.nextInt(input.length());
			result1.append(input.charAt(index));
		}
		return result1.toString();
	}

	public static String shuffleString(String input) {
		List<String> result = Arrays.asList(input.split(""));
		Collections.shuffle(result);
		StringBuilder sbuilder = new StringBuilder();
		for (String letter : result) {
			sbuilder.append(letter);

		}
		return sbuilder.toString();
	}


}
