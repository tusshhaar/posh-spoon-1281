package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerCurrentUserSession;
import com.masai.model.CustomerLoginDTO;
import com.masai.model.RandomString;
import com.masai.repository.CustomerRepo;
import com.masai.repository.CustomerSessionRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private CustomerSessionRepo sessionRepo;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		Customer customer2 = cRepo.findByCustomerUsername(customer.getCustomerUsername());
		
		if(customer2!=null) {
			
			throw new CustomerException("Customer already exists with this username");
			
		}else
			
			cRepo.save(customer);
		
		return customer;
	}

	@Override
	public String loginCustomer(CustomerLoginDTO loginDTO) throws CustomerException {
		
		Customer customer = cRepo.findByCustomerUsername(loginDTO.getCustomerUsername());
		
		if(customer == null) {
			
			throw new CustomerException("Please enter valid username");
			
		}
		
		else {
			
			Optional<CustomerCurrentUserSession> session = sessionRepo.findById(customer.getCustomerId());
			
			if(session.isPresent()) {
				
				throw new CustomerException("User is already loged in");
				
			}else {
				
				if(customer.getCustomerPassword().equals(loginDTO.getCustomerPassword())) {
					
					String key = RandomString.getAlphaNumericString(6);
					
					CustomerCurrentUserSession current = new CustomerCurrentUserSession(customer.getCustomerId(), key, LocalDateTime.now());
					
					sessionRepo.save(current);
					
					return current.toString();
					
				}else
					
					throw new CustomerException("please enter valid password");
			}
		}

		
	}

	@Override
	public String logoutCustomer(String key) throws CustomerException {
		
		CustomerCurrentUserSession session = sessionRepo.findByCustomerUuid(key); 
		
		if(session!=null) {
			
			sessionRepo.delete(session);
			
			return session.toString();
			
		}else
			
			throw new CustomerException("Please enter a valid key");
		
		
		
	}

}
