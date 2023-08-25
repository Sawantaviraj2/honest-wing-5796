package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.masaischool.entity.Vaccine;
import com.masaischool.service.VaccineService;

@RestController
@CrossOrigin("*")
public class VaccineController {

	@Autowired
	private VaccineService vaccineService;
	
	
	/**
	 *  This maps a GET request to the /vaccines endpoint.

ResponseEntity<List<Vaccine>>: This specifies the response type as a list of Vaccine objects.
The method returns a list of all vaccines.
	 * @return
	 */
	@GetMapping(value = "/vaccines")
	public ResponseEntity<List<Vaccine>> getAllVaccine(){
		return new ResponseEntity<List<Vaccine>>(vaccineService.getAllVaccine() , HttpStatus.ACCEPTED); 
    }
	
	/**
	 * This maps a GET request to the /vaccines/byName/{vaccineName} endpoint.

@PathVariable String vaccineName: This extracts the vaccineName from the URL.
The method returns a vaccine with the specified name.
	 * @param vaccineName
	 * @return
	 */
	@GetMapping(value = "/vaccines/byName/{vaccineName}")
	public ResponseEntity<Vaccine> getVaccineByName(@PathVariable String vaccineName){
		return new ResponseEntity<Vaccine>(vaccineService.getVaccineByName(vaccineName) ,HttpStatus.ACCEPTED);
    }
	
	/**
	 *  This maps a GET request to the /vaccines/{vaccineId} endpoint.

@PathVariable Integer vaccineId: This extracts the vaccineId from the URL.
The method returns a vaccine with the specified ID.
	 * @param vaccineId
	 * @return
	 */
	@GetMapping(value = "/vaccines/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineById(@PathVariable Integer vaccineId){
		return new ResponseEntity<Vaccine>(vaccineService.getVaccineById(vaccineId) ,HttpStatus.ACCEPTED);
    }
	
	/**
	 *  This maps a POST request to the /vaccines/{memberId} endpoint.

@RequestBody Vaccine vaccine: This expects a JSON payload in the request body, representing a Vaccine object.
@PathVariable Integer memberId: This extracts the memberId from the URL.
The method adds a new vaccine associated with the provided memberId.
	 * @param vaccine
	 * @param memberId
	 * @return
	 */
	@PostMapping(value = "/vaccines/{memberId}")
	public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine vaccine, @PathVariable Integer memberId){
		return new ResponseEntity<Vaccine>(vaccineService.addVaccine(vaccine , memberId) ,HttpStatus.ACCEPTED);    
    }
	
	/**
	 * This maps a PUT request to the /vaccines/{vaccineId} endpoint.

@PathVariable Integer vaccineId: This extracts the vaccineId from the URL.
@RequestBody Vaccine vaccine: This expects a JSON payload in the request body, representing a Vaccine object.
The method updates an existing vaccine based on the provided vaccineId.
	 * @param vaccineId
	 * @param vaccine
	 * @return
	 */
	@PutMapping(value = "/vaccines/{vaccineId}")
	public ResponseEntity<Vaccine> updateVaccine(@PathVariable Integer vaccineId,@RequestBody Vaccine vaccine){
		return new ResponseEntity<Vaccine>(vaccineService.updateVaccine(vaccineId , vaccine) ,HttpStatus.ACCEPTED);    
    }
	
	/**
	 *  This maps a DELETE request to the /vaccines/{vaccineId} endpoint.

@PathVariable Integer vaccineId: This extracts the vaccineId from the URL.
The method deletes a vaccine based on the provided vaccineId.
	 * @param vaccineId
	 * @return
	 */

	@DeleteMapping(value = "/vaccines/vaccineId")
	public ResponseEntity<String> deleteVaccine(@PathVariable Integer vaccineId){
		return new ResponseEntity<String>(vaccineService.deleteVaccine(vaccineId ) ,HttpStatus.ACCEPTED);    // changing to -> "Boolean" deleteVaccine in VaccineService file
    }
	
	
}
