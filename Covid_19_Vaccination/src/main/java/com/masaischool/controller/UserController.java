package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/getallusers/{pageNumber}/{pageSize}")
	public ResponseEntity<List<User>> getListOfAllUsers(@PathVariable int pageNumber, @PathVariable int pageSize) {
		log.info("Retrieves a list of Users");
		Pageable pageRequest = PageRequest.of(pageNumber-1, pageSize);
		List<User> allUser = userService.getAllUser(pageRequest);
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable Integer userId) throws InvalidUserException {
		log.info("Retrieve a User by id");
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/users/aadhar/{AadharNo}")
	public ResponseEntity<User> getUserByAadharNo(@PathVariable String AadharNo) throws InvalidUserException {
		log.info("Retrieve a User by Aadhar No");
		User user = userService.getUserByAadharNo(AadharNo);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/users/pan/{panNo}")
	public ResponseEntity<User> getUserByPanNo(@PathVariable String panNo) throws InvalidUserException {
		log.info("Retrieve a User by pan number");
		User user = userService.getUserByPanNo(panNo);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		log.info("Add a User to database");

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_" + user.getRole().toUpperCase());// ROLE_USER

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

	@GetMapping("/auth/login")
	public ResponseEntity<String> getUserById(Authentication auth) throws InvalidUserException {
		System.out.println("Auth");

		User user = userService.getUserByAadharNo(auth.getName());
		return new ResponseEntity<String>(user.getName() + " Logged In Successfully ", HttpStatus.ACCEPTED);
	}

}
