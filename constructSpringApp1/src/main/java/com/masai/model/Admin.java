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
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	public Admin(Integer adminId, String adminUsername, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	
}
