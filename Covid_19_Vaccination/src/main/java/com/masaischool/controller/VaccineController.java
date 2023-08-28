package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Vaccine;
import com.masaischool.service.VaccineService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class VaccineController {

	private VaccineService vaccineService;

	@Autowired
	public VaccineController(VaccineService vaccineService) {
		super();
		this.vaccineService = vaccineService;
	}

	@PostMapping("/vaccines/{memberId}")
	public ResponseEntity<Vaccine> addVaccine(@Valid @RequestBody Vaccine vaccine, @PathVariable Integer memberId) {
		log.info("Vaccine added");
		return new ResponseEntity<Vaccine>(vaccineService.addVaccine(vaccine, memberId), HttpStatus.CREATED);
	}

	@GetMapping("/vaccines/{vaccineName}")
	public ResponseEntity<Vaccine> getVaccineByName(@PathVariable String vaccineName) {
		log.info("Get Vaccine");
		return new ResponseEntity<Vaccine>(vaccineService.getVaccineByName(vaccineName), HttpStatus.OK);
	}

	@GetMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineById(@PathVariable Integer vaccineId) {
		log.info("Get Vaccine By id");
		return new ResponseEntity<Vaccine>(vaccineService.getVaccineById(vaccineId), HttpStatus.OK);
	}

	@GetMapping("/vaccines/{pageNumber}/{pageSize}")
	public ResponseEntity<List<Vaccine>> getAllVaccine(@PathVariable int pageNumber, @PathVariable int pageSize) {
		log.info("Get Vaccine List");
		Pageable pageRequest = PageRequest.of(pageNumber - 1, pageSize);
		return new ResponseEntity<List<Vaccine>>(vaccineService.getAllVaccine(pageRequest), HttpStatus.OK);
	}

	@PutMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine, @PathVariable Integer vaccineId) {
		log.info("Update Vaccine");
		return new ResponseEntity<Vaccine>(vaccineService.updateVaccine(vaccineId, vaccine), HttpStatus.OK);
	}

	@DeleteMapping("/vaccines/{vaccineId}")
	public ResponseEntity<String> deleteVaccine(@PathVariable Integer vaccineId) {
		log.info("Delete Vaccine");
		return new ResponseEntity<String>(vaccineService.deleteVaccine(vaccineId), HttpStatus.OK);
	}
}
