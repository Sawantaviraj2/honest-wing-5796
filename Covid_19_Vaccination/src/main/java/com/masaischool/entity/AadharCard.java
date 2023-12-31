package com.masaischool.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class AadharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aadharId;
	private Long aadgharNo;
	private Integer userId;

}
