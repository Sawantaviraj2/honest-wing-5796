package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.VaccinationCenter;

public interface VaccinationCenterService {
	
	public List<VaccinationCenter> getAllVaccinationCenter();
	public VaccinationCenter getVaccination(Integer centerId);
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center);
	public VaccinationCenter updateVaccineCenter(Integer centerId , VaccinationCenter center);
	public Boolean deleteVaccinationCenter(Integer centerId);
	
}
