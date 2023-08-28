package com.masaischool.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.VaccineInventory;
import com.masaischool.service.VaccineInventoryService;

@RestController
@CrossOrigin("*")
public class VaccineInventoryController {

	@Autowired
	private VaccineInventoryService vaccineInventoryService;

	/**
	 * This maps a GET request to the /vaccineinventories endpoint.
	 * ResponseEntity<List<VaccineInventory>>: This specifies the response type as a
	 * list of VaccineInventory objects. The method returns a list of all vaccine
	 * inventory items.
	 */
	@GetMapping(value = "/vaccineinventories/{pageNumber}/{pageSize}")
	public ResponseEntity<List<VaccineInventory>> getAllVaccineInventory(@PathVariable int pageNumber, @PathVariable int pageSize) {
		Pageable pageRequest = PageRequest.of(pageNumber-1, pageSize);
		return new ResponseEntity<List<VaccineInventory>>(vaccineInventoryService.getAllVaccineInventory(pageRequest),
				HttpStatus.ACCEPTED);
	}

	/**
	 * This maps a GET request to the /vaccineinventories/bycenter/{center}
	 * endpoint.
	 * 
	 * @PathVariable Integer centerId: This extracts the centerId from the URL. The
	 *               method returns vaccine inventory data specific to the provided
	 *               centerId.
	 * @param centerId
	 * @return
	 */
	@GetMapping(value = "/vaccineinventories/bycenter/{centerId}")
	public ResponseEntity<VaccineInventory> getVaccinationInventoryByCenter(@PathVariable Integer centerId) {
		return new ResponseEntity<VaccineInventory>(vaccineInventoryService.getVaccinationInventoryByCenter(centerId),
				HttpStatus.ACCEPTED);
	}

	/**
	 * This maps a POST request to the /vaccineinventories/{vaxCenterId} endpoint.
	 * 
	 * @PathVariable Integer vaxCenterId: This extracts the vaxCenterId from the
	 *               URL.
	 * @RequestBody VaccineInventory inv: This expects a JSON payload in the request
	 *              body, which represents a VaccineInventory object. The method
	 *              adds a new vaccine inventory count associated with the specified
	 *              vaxCenterId.
	 * @param vaxCenterId
	 * @param inv
	 * @return
	 */
	@PostMapping(value = "/vaccineinventories/{vaxCenterId}")
	public ResponseEntity<VaccineInventory> addVaccineCount(@PathVariable Integer vaxCenterId,
			@RequestBody VaccineInventory inv) {
		return new ResponseEntity<VaccineInventory>(vaccineInventoryService.addVaccineCount(vaxCenterId, inv),
				HttpStatus.ACCEPTED);
	}

	/**
	 * This maps a PUT request to the /vaccineinventories/{vaccineInvenId} endpoint.
	 * 
	 * @PathVariable Integer vaccineInvenId: This extracts the vaccineInvenId from
	 *               the URL.
	 * @RequestBody VaccineInventory inv: This expects a JSON payload in the request
	 *              body, which represents a VaccineInventory object. The method
	 *              updates an existing vaccine inventory entry based on the
	 *              provided vaccineInvenId.
	 * @param vaccineInvenId
	 * @param inv
	 * @return
	 */
	@PutMapping(value = "/vaccineinventories/{vaccineInvenId}")
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@PathVariable Integer vaccineInvenId,
			@RequestBody VaccineInventory inv) {
		return new ResponseEntity<VaccineInventory>(vaccineInventoryService.updateVaccineInventory(vaccineInvenId, inv),
				HttpStatus.ACCEPTED);

	}

	/**
	 * This maps a DELETE request to the /vaccineinventories/{vaccineInvenId}
	 * endpoint.
	 * 
	 * @PathVariable Integer vaccineInvenId: This extracts the vaccineInvenId from
	 *               the URL. The method deletes a vaccine inventory entry based on
	 *               the provided vaccineInvenId.
	 * @param vaccineInvenId
	 * @return
	 */
	@DeleteMapping(value = "/vaccineinventories/{vaccineInvenId}")
	public ResponseEntity<Boolean> deleteVaccinationInventory(@PathVariable Integer vaccineInvenId) {
		return new ResponseEntity<Boolean>(vaccineInventoryService.deleteVaccinationInventory(vaccineInvenId),
				HttpStatus.ACCEPTED);

	}

	/**
	 * This maps a GET request to the /vaccineinventories/{date} endpoint.
	 * 
	 * @PathVariable LocalDate date: This extracts the date from the URL. The method
	 *               returns vaccine inventory data for the specified date.
	 * @param date
	 * @return
	 */
	@GetMapping(value = "/vaccineinventories/date/{date}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDate(@PathVariable LocalDate date) {
		return new ResponseEntity<List<VaccineInventory>>(vaccineInventoryService.getVaccineInventoryByDate(date),
				HttpStatus.ACCEPTED);
	}

	/**
	 * This maps a GET request to the /vaccineinventories/{vaccineId} endpoint.
	 * 
	 * @PathVariable Integer vaccineId: This extracts the vaccineId from the URL.
	 *               The method returns vaccine inventory data for the specified
	 *               vaccine ID.
	 * @param vaccineId
	 * @return
	 */
	@GetMapping(value = "/vaccineinventories/id/{vaccineId}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByVaccine(@PathVariable Integer vaccineId) {
		return new ResponseEntity<List<VaccineInventory>>(
				vaccineInventoryService.getVaccineInventoryByVaccine(vaccineId), HttpStatus.ACCEPTED);
	}

}
