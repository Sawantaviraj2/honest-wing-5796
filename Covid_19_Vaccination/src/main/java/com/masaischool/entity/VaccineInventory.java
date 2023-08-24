package com.masaischool.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class VaccineInventory {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private  Integer inventoryId;
	    private LocalDate date;
	    
	    @OneToOne(mappedBy = "vaxInventory" , cascade = CascadeType.ALL)
	    private VaccinationCenter vaxCenter;
	    
	    @OneToMany(mappedBy = "vaxInventory", cascade = CascadeType.ALL)
	    private List<VaccineCount> vaxCount;
	
}
