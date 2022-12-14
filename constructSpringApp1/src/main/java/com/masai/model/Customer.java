package com.masai.model;

import jakarta.persistence.Entity;

@Entity
public class Customer {

	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String username;
	
}
