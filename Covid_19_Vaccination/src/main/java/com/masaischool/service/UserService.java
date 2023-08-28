package com.masaischool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.masaischool.entity.User;
import com.masaischool.exception.InvalidUserException;

public interface UserService {

	/**
	 * Retrieves a list of all users with page and size
	 * 
	 * @return A list of all users in the repository.
	 */
	public List<User> getAllUser(Pageable pageable);
	
	/**
	 * Retrieves a user by their ID.
	 * 
	 * @param id The ID of the user to retrieve.
	 * @return The user with the specified ID.
	 * @throws InvalidUserException If no user is found with the given ID.
	 */
	public User getUserById(Integer id) throws InvalidUserException;
	
	/**
	 * Retrieves a user by their Aadhar number.
	 * 
	 * @param aadharNo The Aadhar number of the user to retrieve.
	 * @return The user with the specified Aadhar number.
	 * @throws InvalidUserException If no user is found with the given Aadhar number.
	 */
	public User getUserByAadharNo(String aadharNo) throws InvalidUserException;
	
	/**
	 * Retrieves a user by their PAN number.
	 * 
	 * @param panNo The PAN number of the user to retrieve.
	 * @return The user with the specified PAN number.
	 * @throws InvalidUserException If no user is found with the given PAN number.
	 */
	public User getUserByPanNo(String panNo) throws InvalidUserException;
	
	/**
	 * Adds a new user.
	 * 
	 * @param member The user to add.
	 * @return The added user.
	 */
	public User addUser(User member);
	
	/**
	 * Updates an existing user's information.
	 * 
	 * @param userId The ID of the user to update.
	 * @param member The updated user information.
	 * @return The updated user.
	 * @throws InvalidUserException If no user is found with the given ID.
	 */
	public User updateUser(Integer userId , User member) throws InvalidUserException;
	
	/**
	 * Deletes a user by their ID.
	 * 
	 * @param id The ID of the user to delete.
	 * @return True if the user was deleted successfully, false otherwise.
	 * @throws InvalidUserException If no user is found with the given ID.
	 */
	public Boolean deleteUser(Integer id) throws InvalidUserException;
	
}
