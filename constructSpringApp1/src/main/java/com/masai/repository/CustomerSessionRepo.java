package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerCurrentUserSession;

public interface CustomerSessionRepo extends JpaRepository<CustomerCurrentUserSession, Integer> {
	
	public CustomerCurrentUserSession findByCustomerUuid(String customerUuid);

}
