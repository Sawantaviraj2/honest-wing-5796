package com.masaischool.service.SerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masaischool.entity.VaccinationCenter;
import com.masaischool.exception.VaccineNotFoundException;
import com.masaischool.repository.VaccinationCenterRepository;
import com.masaischool.service.VaccinationCenterService;

@Service
public class VaccinationCenterServiceImp implements VaccinationCenterService {

	// Injects a dependency into the class
	private VaccinationCenterRepository vaccinationCenterRepository;

	@Autowired
	public VaccinationCenterServiceImp(VaccinationCenterRepository vaccinationCenterRepository) {
		super();
		this.vaccinationCenterRepository = vaccinationCenterRepository;
	}

	// Retrieves a list of all vaccination centers from the repository
	@Override
	public List<VaccinationCenter> getAllVaccinationCenter(Pageable pageable) {
		
		Page<VaccinationCenter> list = vaccinationCenterRepository.findAll(pageable);
		if (list == null)
			throw new VaccineNotFoundException("not any Vaccination Center"); // Connection for Exception here
		return list.toList();
	}

	// Retrieves a specific vaccination center by its ID from the repository
	@Override
	public VaccinationCenter getVaccination(Integer centerId) {
		if (centerId == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Id");
		Optional<VaccinationCenter> optional = vaccinationCenterRepository.findById(centerId);
		if (optional.isEmpty())
			throw new VaccineNotFoundException("Vaccination Center Not Found By Given Id");
		return optional.get();
	}

	// Adds a new vaccination center to the repository
	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) {
		if (center == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Details");
		return vaccinationCenterRepository.save(center);
	}

	// Updates an existing vaccination center's information in the repository.
	@Override
	public VaccinationCenter updateVaccineCenter(Integer centerId, VaccinationCenter center) {
		if (centerId == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Id");
		if (center == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center");
		center.setCenterId(centerId);
		return vaccinationCenterRepository.save(center);
	}

	// Deletes a vaccination center from the repository based on its ID.
	@Override
	public Boolean deleteVaccinationCenter(Integer centerId) {
		if (centerId == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Id");
		vaccinationCenterRepository.deleteById(centerId);
		return true;
	}

}
