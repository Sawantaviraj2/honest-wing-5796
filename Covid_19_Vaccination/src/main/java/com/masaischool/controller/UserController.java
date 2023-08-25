package com.masaischool.controller;

import java.util.List;

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

import com.masaischool.entity.User;
import com.masaischool.exception.InvalidUserException;
import com.masaischool.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(value = "*")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getListOfAllUsers() {
		log.info("Retrieves a list of Users");
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable Integer userId) throws InvalidUserException {
		log.info("Retrieve a User by id");
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/users/{AadharNo}")
	public ResponseEntity<User> getUserByAadharNo(@PathVariable String AadharNo) throws InvalidUserException {
		log.info("Retrieve a User by Aadhar No");
		User user = userService.getUserByAadharNo(AadharNo);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/users/{panNo}")
	public ResponseEntity<User> getUserByPanNo(@PathVariable String panNo) throws InvalidUserException {
		log.info("Retrieve a User by pan number");
		User user = userService.getUserByPanNo(panNo);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		log.info("Add a User to database");
		User addUser = userService.addUser(user);
		return new ResponseEntity<User>(addUser, HttpStatus.CREATED);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Integer userId, @Valid @RequestBody User user)
			throws InvalidUserException {
		log.info("Update a User in database");
		User updatedUser = userService.updateUser(userId, user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Boolean> deleteUserByUserId(@PathVariable Integer userId) throws InvalidUserException {
		log.info("Deleted a User from database");
		Boolean deleteUser = userService.deleteUser(userId);
		return new ResponseEntity<Boolean>(deleteUser, HttpStatus.OK);
	}
}
