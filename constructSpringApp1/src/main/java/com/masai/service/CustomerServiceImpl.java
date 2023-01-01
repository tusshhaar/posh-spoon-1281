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
					
					return current.getCustomerUuid();
					
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

	@Override
	public Customer upDateCustomer(Customer customer, String key) throws CustomerException {
		
		CustomerCurrentUserSession session = sessionRepo.findByCustomerUuid(key);
		
		if(session==null) {
			
			throw new CustomerException("Please enter a valid key");
			
		}else if(session.getCustomerId()==customer.getCustomerId()) {
			
			Customer updateCustomer = cRepo.save(customer);
			
			return updateCustomer;
			
		}
		else
			
			throw new CustomerException("Inavlid credentials please login first");
		
	}

	@Override
	public Customer seeProfile(Integer id) throws CustomerException {
		
		Optional<CustomerCurrentUserSession> session = sessionRepo.findById(id);
		
		if(session.isPresent()) {
			
			Optional<Customer> c = cRepo.findById(session.get().getCustomerId());
			Customer customer = c.get();
			
			return customer;
			
		}else
			
			throw new CustomerException("Please enter valid id or login first");
		
	}
	
	
	

}
