package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginDTO;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@PutMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer c1) throws CustomerException{
		
		Customer customer = cService.registerCustomer(c1);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody CustomerLoginDTO dto) throws CustomerException{
		
		String str = cService.loginCustomer(dto);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam("key") String key) throws CustomerException{
		
		String str = cService.logoutCustomer(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
}
