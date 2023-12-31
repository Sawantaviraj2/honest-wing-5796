package com.masaischool.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Member {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(columnDefinition = "boolean default false")
	 private Boolean dose1Status;
	 
	 @Column(columnDefinition = "boolean default false")
	 private Boolean dose2Status;
	 
	 private LocalDate dose1Date;
	 
	 private LocalDate dose2Date;
	 
     private Long mobNo;
	 
	 private LocalDate dateOfRegistration = LocalDate.now();
	 
	 @JsonIgnore
	 @OneToOne(cascade = CascadeType.ALL)
	 private User user;
	 
	 @JsonIgnore
	 @OneToOne(mappedBy = "memberId", cascade = CascadeType.ALL)
	 private Appointment appointment;
	 
	 @JsonIgnore
	 @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	 private Vaccine vaccine;
	 
	 
}
