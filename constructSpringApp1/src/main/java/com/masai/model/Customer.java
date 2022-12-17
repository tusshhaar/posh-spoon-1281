package com.masai.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	@NotEmpty
	@Size(min = 3, message = "Costomer Name should contain 2 or more than 2 latters !!")
	private String customerName;
	@NotEmpty
	@Email
	@Pattern(regexp ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Please Enter valid Email Id included @ and proper Name !!" )
	private String customerEmail;
	@NotEmpty
	@Size(min = 4, message = "Costomer Username should contain 4 or more than 4 latters !!")
	private String customerUsername;
	@NotEmpty
	@Size(min = 4, max=10, message = "customer password should contains the minimum 4 and maximum 10 chars !!")
	private String customerPassword;

	//@NotEmpty(message =  "Address is mandatory")
	@Embedded
	private Address address;
	
}
