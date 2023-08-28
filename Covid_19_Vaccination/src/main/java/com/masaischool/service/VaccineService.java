
package com.masaischool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.masaischool.entity.Vaccine;

public interface VaccineService {
	/**
	 * This method gets all the vaccines 
	 * @return List of Vaccine 
	 */
	public List<Vaccine> getAllVaccine(Pageable pageable);
	
	/**
	 * This Method gets the vaccine by the name
	 * @param vaccineName String Type
	 * @return Object Of Vaccine
	 */
	public Vaccine getVaccineByName(String vaccineName);
	
	/**
	 * This method gets the vaccine by the Id
	 * @param vaccineId Integer
	 * @return Object Of Vaccine
	 */
	public Vaccine getVaccineById(Integer vaccineId);
	
	/**
	 * This method adds a new Vaccine
	 * @param vaccine Object Of vaccine
	 * @param memberId Integer
	 * @return Object Of Vaccine
	 */
	public Vaccine addVaccine(Vaccine vaccine, Integer memberId);
	
	/**
	 * This method updates the vaccine
	 * @param vaccineId Integer
	 * @param vaccine Object Of Vaccine
	 * @return Object Of Vaccine
	 */
	public Vaccine updateVaccine(Integer vaccineId, Vaccine vaccine);
	
	/**
	 * This method deletes an existing vaccine
	 * @param vaccineId Integer
	 * @return String With Information
	 */
	public String deleteVaccine(Integer vaccineId);
}
