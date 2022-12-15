package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
	
	@Id
	private Integer adminId;
	private String adminUsername;
	private String adminPassword;
	
	
}
