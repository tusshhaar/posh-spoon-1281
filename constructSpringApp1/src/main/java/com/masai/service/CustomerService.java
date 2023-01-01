package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginDTO;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws CustomerException;
	
	public String loginCustomer(CustomerLoginDTO loginDTO) throws CustomerException;
	
	public String logoutCustomer(String key) throws CustomerException;
	
	public Customer upDateCustomer(Customer customer, String key) throws CustomerException;
	
	public Customer seeProfile(Integer id) throws CustomerException;
	
}
