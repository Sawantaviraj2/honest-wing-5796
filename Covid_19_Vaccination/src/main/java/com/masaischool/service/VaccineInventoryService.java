package com.masaischool.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.masaischool.entity.VaccineInventory;

public interface VaccineInventoryService {
	
	public List<VaccineInventory> getAllVaccineInventory(Pageable pageable);
	public VaccineInventory getVaccinationInventoryByCenter(Integer centerId);
	public VaccineInventory addVaccineCount(Integer vaxCenterId ,VaccineInventory inv);
	public VaccineInventory updateVaccineInventory(Integer vaccineInvenId,VaccineInventory inv);
	public Boolean deleteVaccinationInventory(Integer vaccineInvenId);
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date);
	public List<VaccineInventory> getVaccineInventoryByVaccine(Integer vaccineId);
}
