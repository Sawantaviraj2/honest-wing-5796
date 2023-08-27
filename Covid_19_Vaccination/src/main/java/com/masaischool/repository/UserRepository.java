package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByAadharNo(String aadharNo);

	public Optional<User> findByEmail(String email);

	public Optional<User> findByPanNo(String panNo);

}
