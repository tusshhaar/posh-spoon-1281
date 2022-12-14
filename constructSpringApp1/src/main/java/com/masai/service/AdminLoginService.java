package com.masai.service;

import com.masai.exception.AdminLoginException;
import com.masai.model.AdminLoginDTO;

public interface AdminLoginService {
	
	public String adminLoginDTO(AdminLoginDTO admin) throws AdminLoginException;
	
	public String adminLogoutDTO(String key) throws AdminLoginException;
}
