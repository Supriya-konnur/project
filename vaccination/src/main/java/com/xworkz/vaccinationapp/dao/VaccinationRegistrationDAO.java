package com.xworkz.vaccinationapp.dao;

import com.xworkz.vaccinationapp.entity.VaccinationEntity;

public interface VaccinationRegistrationDAO {

	public VaccinationEntity emailVerification(String email);
}
