package com.masaischool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AadhaarCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aadhaarId;
	private Long aadhaarNo;
	private User user;
}
