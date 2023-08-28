package com.masaischool.service.SerImpl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masaischool.entity.User;
import com.masaischool.exception.InvalidUserException;
import com.masaischool.repository.UserRepository;
import com.masaischool.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public List<User> getAllUser(Pageable pageable) {
		return userRepository.findAll(pageable).toList();
	}


	public User getUserById(Integer id) throws InvalidUserException {
		return userRepository.findById(id)
				.orElseThrow(() -> new InvalidUserException("User not found for this id : " + id));
	}


	public User getUserByAadharNo(String aadharNo) throws InvalidUserException {
		// TODO Auto-generated method stub
		return userRepository.findByAadharNo(aadharNo)
				.orElseThrow(() -> new InvalidUserException("No user found with this Aadhar number : " + aadharNo));

	}

	public User getUserByPanNo(String panNo) throws InvalidUserException {
		return userRepository.findByPanNo(panNo)
				.orElseThrow(() -> new InvalidUserException("User not found for this pan number : " + panNo));
	}

	
	public User addUser(User member) {
		return userRepository.save(member);
	}

	
	public User updateUser(Integer userId, User member) throws InvalidUserException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new InvalidUserException("User not found for this id : " + userId));

		if (member.getName() != null) {
			user.setName(member.getName());
		}
		if (member.getDob() != null) {
			user.setDob(member.getDob());
		}
		if (member.getGender() != null) {
			user.setGender(member.getGender());
		}
		if (member.getAddress() != null) {
			user.setAddress(member.getAddress());
		}
		if (member.getCity() != null) {
			user.setCity(member.getCity());
		}
		if (member.getState() != null) {
			user.setState(member.getState());
		}
		if (member.getPincode() != null) {
			user.setPanNo(member.getPincode());
		}
		if (member.getPassword() != null) {
			user.setPassword(member.getPassword());
		}
		if (member.getRole() != null) {
			user.setRole(member.getRole());
		}
		if (member.getPanNo() != null) {
			user.setPanNo(member.getPanNo());
		}
		if (member.getAadharNo() != null) {
			user.setAadharNo(member.getAadharNo());
		}

		return userRepository.save(user);
	}

	
	public Boolean deleteUser(Integer id) throws InvalidUserException {
		User user = userRepository.findById(id).orElseThrow(()-> new InvalidUserException("User not found for this id :"+id));
		
		if(user!=null) {
			userRepository.deleteById(user.getId());
			return true;
		}
		return false;
	}

}
