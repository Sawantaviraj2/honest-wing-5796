package com.masaischool.service.SerImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masaischool.entity.VaccinationCenter;
import com.masaischool.entity.VaccineInventory;
import com.masaischool.exception.VaccineNotFoundException;
import com.masaischool.repository.VaccinationCenterRepository;
import com.masaischool.repository.VaccineInventoryRepository;
import com.masaischool.service.VaccineInventoryService;

@Service
public class VaccineInventoryServiceImp implements VaccineInventoryService {
	private VaccineInventoryRepository vaccineInventoryRepository;
	private VaccinationCenterRepository vaccinationCenterRepository;

	@Autowired
	public VaccineInventoryServiceImp(VaccineInventoryRepository vaccineInventoryRepository,
			VaccinationCenterRepository vaccinationCenterRepository) {
		this.vaccineInventoryRepository = vaccineInventoryRepository;
		this.vaccinationCenterRepository = vaccinationCenterRepository;
	}

	// Retrieves a list of all vaccine inventory items
	@Override
	public List<VaccineInventory> getAllVaccineInventory(Pageable pageable) {
		Page<VaccineInventory> list = vaccineInventoryRepository.findAll(pageable);
		if (list.isEmpty())
			throw new VaccineNotFoundException("Not Any Vaccine Inventory Found");
		return list.toList();
	}

	

	// Retrieve vaccine inventory for a specific vaccination center
	@Override
	public VaccineInventory getVaccinationInventoryByCenter(Integer centerId) {
		VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findById(centerId).get();
		VaccineInventory vaxInventory = vaccinationCenter.getVaxInventory();
		return vaxInventory;
	}

	// Adds a new vaccine inventory count for a specified vaccination center.
	// It ensures the provided vaccination center ID is valid, associates the
	// inventory with the center, and saves the inventory to the repository
	@Override
	public VaccineInventory addVaccineCount(Integer vaxCenterId, VaccineInventory inv) {

		Optional<VaccinationCenter> optional = vaccinationCenterRepository.findById(vaxCenterId);
		if (optional.isEmpty())
			throw new VaccineNotFoundException("Vax Center Not Found");
		inv.setVaxCenter(optional.get());
		optional.get().setVaxInventory(inv);
		return vaccineInventoryRepository.save(inv);
	}

	// Updates an existing vaccine inventory entry.
	// It checks for valid input parameters, sets the inventory ID, and saves the
	// updated inventory to the repository.
	@Override
	public VaccineInventory updateVaccineInventory(Integer vaccineInvenId, VaccineInventory inv) {

		if (vaccineInvenId == null)
			throw new VaccineNotFoundException("Please provide Vaccination inventory id to update");

		if (inv == null)
			throw new VaccineNotFoundException("Please provide Vaccination inventory details to update");

		inv.setInventoryId(vaccineInvenId);

		return vaccineInventoryRepository.save(inv);
	}

	// Deletes a vaccine inventory entry based on its ID.
	@Override
	public Boolean deleteVaccinationInventory(Integer vaccineInvenId) {
		if (vaccineInvenId == null)
			throw new VaccineNotFoundException("Please provide Vaccination inventory id to delete");
		vaccineInventoryRepository.deleteById(vaccineInvenId);
		return true;
	}

	// Retrieves a list of vaccine inventory items for a given date.
	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) {
		List<VaccineInventory> list = vaccineInventoryRepository.findByDate(date);
		if (list.size() == 0)
			throw new VaccineNotFoundException("Vaccine inventory not found on given date");
		return list;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(Integer vaccineId) {
		List<VaccineInventory> findByVaccineId = vaccineInventoryRepository.findByVaccineId(vaccineId);
		return findByVaccineId;
	}

}
