package com.xworkz.vaccinationapp.service;

import com.xworkz.vaccinationapp.dto.VaccinationDTO;

public interface VaccinationService {

	public boolean validateAndSave(VaccinationDTO vDTO);
}
