package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminLoginException;
import com.masai.model.AdminCurrentUserSession;
import com.masai.model.OrderTable;
import com.masai.repository.AdminSessionRepo;
import com.masai.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo oRepo;
	
	@Autowired
	private AdminSessionRepo aRepo;

	@Override
	public String addPlanter(OrderTable order, String key) throws AdminLoginException {

		AdminCurrentUserSession adminSession = aRepo.findByAdminUuid(key);
		
		if(adminSession!=null) {
			
			OrderTable registerOrder = oRepo.save(order);
			
			return registerOrder.toString();
			
		}else
			
			throw new AdminLoginException("You are not authorize");

		
	}

}
