

package com.jsp.springboot_hospitalmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String state;
	private String city;
	@NotNull(message = "pincode cannot be null")
	@Min(value = 000001)
	@Max(value = 999999)
	private long pincode;
}


