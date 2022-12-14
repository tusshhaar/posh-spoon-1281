package com.masai.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminLoginDTO {

	@NotNull(message = "username should be mandatory")
	@NotEmpty(message = "username should be mandatory")
	private String adminUsername;
	
	@NotNull(message = "password should be mandatory")
	@NotEmpty(message = "password should be mandatory")
	private String adminPassword;
	
	public AdminLoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminLoginDTO(String adminUsername, String adminPassword) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
