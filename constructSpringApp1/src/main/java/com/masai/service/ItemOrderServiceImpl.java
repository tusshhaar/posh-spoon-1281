package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.ItemOrder;
import com.masai.model.Planter;
import com.masai.repository.ItemOrderRepo;
import com.masai.repository.PlanterRepo;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
	
	@Autowired
	private ItemOrderRepo iRepo;
	
	@Autowired
	private PlanterRepo pRepo;
//
	@Override
	public Planter findSeedWithPlanter(String seed) {
		
		 Planter planter = pRepo.getPlanterBySeed(seed);
		 
		 if(planter==null) {
			 
			 throw new IllegalArgumentException("There is no planter available for seed :"+seed);
		 }
		 else
		
		
		return planter;
	}



}
