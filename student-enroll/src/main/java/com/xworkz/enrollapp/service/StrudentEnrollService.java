package com.xworkz.enrollapp.service;

import com.xworkz.enrollapp.dto.StudentEnrollDTO;

public interface StrudentEnrollService {
	
	public boolean validateAndSave(StudentEnrollDTO sDTO);
}
