package com.xworkz.vaccinationapp.service;

import com.xworkz.vaccinationapp.dto.VaccinationDTO;

public interface VaccinationService {

//	public boolean validateAndSave(VaccinationDTO vDTO);

	public boolean registerServiceValidate(VaccinationDTO vdto);

	public boolean save(VaccinationDTO vdto);
}
