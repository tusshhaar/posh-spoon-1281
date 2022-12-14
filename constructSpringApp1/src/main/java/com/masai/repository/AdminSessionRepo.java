package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.AdminCurrentUserSession;

public interface AdminSessionRepo extends JpaRepository<AdminCurrentUserSession, Integer> {
	
	public AdminCurrentUserSession findByAdminUuid(String adminUuid);

}
