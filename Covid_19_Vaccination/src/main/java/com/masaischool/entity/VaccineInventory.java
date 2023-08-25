package com.masaischool.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoryId;
	private LocalDate date;

	@JsonIgnore
	@OneToOne(mappedBy = "vaxInventory", cascade = CascadeType.ALL)
	private VaccinationCenter vaxCenter;

	@JsonIgnore
	@OneToMany(mappedBy = "vaxInventory", cascade = CascadeType.ALL)
	private List<VaccineCount> vaxCount;
	
	private Integer vaccineId;

	public VaccineInventory(LocalDate date, List<VaccineCount> vaxCount) {
		super();
		this.date = date;
	}

}
