package com.masaischool.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
{
    "name" : "Luffy",
    "dob":"2003-07-12",
    "gender":"Male",
    "city":"Sea",
    "address":"East Blue",
    "state":"East Ocean",
    "pincode":"124545",
    "email" : "luffy@gmail.com",
    "password" : "luffy123",
    "role" : "USER",
    "panNo":"BCA54YPQ",
    "aadharNo":"305068540349"
}
 */
@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 2, max = 20)
	private String name;
	@Past(message = "Invalid date of birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@NotNull(message = "Gender must be specified")
	private String gender;
	@Size(min = 2, max = 80)
	private String address;
	@Size(min = 2, max = 40)
	private String city;
	@Size(min = 2, max = 40)
	private String state;
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid  PIN code")
	private String pincode;
	@Email(message = "Provide Email in valid format")
	@Column(unique = true)
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String role;

	private String panNo;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Please provide value for addharNo")
	private String aadharNo;

	@JsonIgnore
	@OneToOne
	private Member member;

}
