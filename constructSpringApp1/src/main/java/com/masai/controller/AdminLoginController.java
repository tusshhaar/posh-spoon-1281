package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminLoginException;
import com.masai.model.AdminLoginDTO;
import com.masai.service.AdminLoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService aLoginService;
	
	@PutMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLoginDTO loginDTO) throws AdminLoginException{
		
		String str = aLoginService.adminLoginDTO(loginDTO);
		
		return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<String> adminLogout(@Valid @RequestParam("key") String key) throws AdminLoginException{
		
		String str = aLoginService.adminLogoutDTO(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
}
