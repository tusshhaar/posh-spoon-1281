package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminCurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer adminId;
	
	private String adminUuid;
	
	private LocalDateTime localDateTime;
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminUuid() {
		return adminUuid;
	}
	public void setAdminUuid(String adminUuid) {
		this.adminUuid = adminUuid;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public AdminCurrentUserSession(Integer adminId, String adminUuid, LocalDateTime localDateTime) {
		super();
		this.adminId = adminId;
		this.adminUuid = adminUuid;
		this.localDateTime = localDateTime;
	}
	
	public AdminCurrentUserSession() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminCurrentUserSession [adminId=" + adminId + ", adminUuid=" + adminUuid + ", localDateTime="
				+ localDateTime + "]";
	}
	
	
}
