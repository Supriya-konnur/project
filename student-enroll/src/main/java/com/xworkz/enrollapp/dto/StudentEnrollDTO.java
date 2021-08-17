package com.xworkz.enrollapp.dto;

import java.io.Serializable;

import com.xworkz.enrollapp.util.PasswordGeneratorUtil;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentEnrollDTO implements Serializable{

	private int id;
	private String name;
	private String email;
	@Setter(value = AccessLevel.NONE)
	private String password = PasswordGeneratorUtil.generateStrongPassword(8);
}
