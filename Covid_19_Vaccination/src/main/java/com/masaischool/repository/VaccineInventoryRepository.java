package com.masaischool.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.entity.VaccineInventory;

public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Integer> {

	public List<VaccineInventory> findByDate(LocalDate date);
	public List<VaccineInventory> findByVaccineId(Integer vaccineId);
	
}
