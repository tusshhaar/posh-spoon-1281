package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private Integer addressId;
	private String houseNo;
	private String colony;
	private String city;
	private String state;
	private Integer pincode;
}
