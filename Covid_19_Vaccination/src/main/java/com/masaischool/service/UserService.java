package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.User;
import com.masaischool.exception.InvalidUserException;

public interface UserService {

	public List<User> getAllUser();
	public User getUserById(Integer id) throws InvalidUserException;
	public User getUserByAadharNo(String aadharNo) throws InvalidUserException;
	public User getUserByPanNo(String panNo) throws InvalidUserException;
	public User addUser(User member);
	public User updateUser(Integer userId , User member) throws InvalidUserException;
	public Boolean deleteUser(Integer id) throws InvalidUserException;
	
}
