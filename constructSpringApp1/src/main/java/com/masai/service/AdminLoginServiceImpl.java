package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.AdminSessionRepo;
import com.masai.repository.CustomerRepo;
import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.model.Admin;
import com.masai.model.AdminCurrentUserSession;
import com.masai.model.AdminLoginDTO;
import com.masai.model.Customer;
import com.masai.model.RandomString;
import com.masai.repository.AdminRepo;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private AdminSessionRepo loggedRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	//ADMIN LOGIN

	@Override
	public String adminLoginDTO(AdminLoginDTO admin) throws AdminLoginException {
		
		Admin adm = adminRepo.findByAdminUsername(admin.getAdminUsername());
		
		if(adm==null) {
			
			throw new AdminLoginException("Please enter a valid username");
			
		}
		
		Optional<AdminCurrentUserSession> session = loggedRepo.findById(adm.getAdminId());
		
		if(session.isPresent()) {
			
			throw new AdminLoginException("User is already exists");
		}
		else
			
			if(adm.getAdminPassword().equals(admin.getAdminPassword())) {
				
				String key = RandomString.getAlphaNumericString(6);
				
				AdminCurrentUserSession adminSession = new AdminCurrentUserSession(adm.getAdminId(), key, LocalDateTime.now());
				
				loggedRepo.save(adminSession);
				
				return adminSession.toString();
				
			}else
				
				throw new AdminLoginException("Please enter valid password");
		
	}
	
	//ADMIN LOGOUT

	@Override
	public String adminLogoutDTO(String key) throws AdminLoginException {
		
		AdminCurrentUserSession current = loggedRepo.findByAdminUuid(key);
		
		if(current!=null) {
			
			loggedRepo.delete(current);
			
			return current.toString();
		}else
			
			throw new AdminLoginException("Please enter a valid key");
		
	}

	@Override
	public List<Customer> viewAllCustomers(String key) throws CustomerException {
		
		AdminCurrentUserSession adminSession = loggedRepo.findByAdminUuid(key);
		
		if(adminSession==null) {
			
			throw new CustomerException("You are not authorize. Only admin can see the customer list");
			
		}
			
			List<Customer> customers = customerRepo.findAll();
			
			return customers;
		
	}

}
