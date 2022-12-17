package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.exception.SeedException;
import com.masai.model.AdminLoginDTO;
import com.masai.model.Customer;
import com.masai.model.Seed;
import com.masai.service.AdminLoginService;
import com.masai.service.SeedServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService aLoginService;
	@Autowired
	private SeedServices seedServices;
	@GetMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLoginDTO loginDTO) throws AdminLoginException{
		
		String str = aLoginService.adminLoginDTO(loginDTO);
		
		return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> adminLogout(@Valid @RequestParam("key") String key) throws AdminLoginException{
		
		String str = aLoginService.adminLogoutDTO(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/customers/{key}")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("key") String key) throws CustomerException{
		
		List<Customer> customers = aLoginService.viewAllCustomers(key);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@PostMapping("/Seed/{key}")
	public ResponseEntity<Seed> addSeedHandler(@RequestBody Seed seed, @PathVariable("key") String key) throws SeedException, AdminLoginException{
		Seed obj=seedServices.addSeed(seed, key);
		
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
		
	}
	
}
