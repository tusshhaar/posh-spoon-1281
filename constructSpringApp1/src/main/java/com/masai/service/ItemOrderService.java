package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.exception.PlanterException;
import com.masai.model.ItemOrder;
import com.masai.model.Plant;
import com.masai.model.Planter;

public interface ItemOrderService {
	
	
	public List<Planter> findSeedWithPlanter(String seed, String key) throws OrderException, CustomerException, PlanterException;
	
	public List<Planter> findPlantWithPlanter(String plantName, String key) throws OrderException, CustomerException, PlanterException;
	
	public String buyPlanterWithSeed(ItemOrder order, String key, Integer planterId) throws CustomerException, PlanterException;
	
	public String buyPlanterWithPlant(ItemOrder order, String key, Integer planterId) throws CustomerException, PlanterException;

	public Planter buyPlanterBYShapeAndId(String key, String shape, Integer planterId) throws CustomerException, PlanterException;
	
	public List<Plant> viewPlantByName(String key, String name) throws CustomerException, PlanterException;
	
	public Plant buyPlantWithNameAndId(String name, Integer id, String key) throws CustomerException, PlanterException;
	
	
	
}
