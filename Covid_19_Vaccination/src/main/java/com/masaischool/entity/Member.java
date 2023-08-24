package com.masaischool.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Member {

	private Integer memberId;

	private Boolean doseOneStatus;

	private Boolean doseTwoStatus;

	private LocalDate dose1Date;

	private LocalDate dose2Date;

	private Long mobNo;

	private LocalDate dateOfRegistration = LocalDate.now();
	
	
}
