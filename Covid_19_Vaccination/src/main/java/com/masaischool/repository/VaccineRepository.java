package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masaischool.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

	@Query("SELECT v FROM Vaccine v WHERE v.vaxName = ?1")
	Optional<Vaccine> findByVaxName(String vaccineName);

}
