
package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Vaccine;

public interface VaccineService {
	public List<Vaccine> getAllVaccine();

	public Vaccine getVaccineByName(String vaccineName);

	public Vaccine getVaccineById(Integer vaccineId);

	public Vaccine addVaccine(Vaccine vaccine, Integer memberId);

	public Vaccine updateVaccine(Integer vaccineId, Vaccine vaccine);

	public String deleteVaccine(Integer vaccineId);
}
