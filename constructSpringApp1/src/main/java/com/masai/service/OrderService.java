package com.masai.service;

import com.masai.exception.AdminLoginException;
import com.masai.model.OrderTable;

public interface OrderService {
	
	public String addPlanter(OrderTable order, String key) throws AdminLoginException;

}
