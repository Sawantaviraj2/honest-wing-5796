package com.masaischool.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String name;

	private LocalDate dob;

	private String gender;

	private Address address;

	private String email;

	private String password;

	private String role;

	private String panNo;

	private AadhaarCard adharCard;

	private Member member;

}
