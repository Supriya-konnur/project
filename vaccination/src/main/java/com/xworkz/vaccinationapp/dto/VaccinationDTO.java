package com.xworkz.vaccinationapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class VaccinationDTO {

	private int id;
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private String phone;
	private String typeOfVaccine;
	private String otp;
	private String gender;
}
