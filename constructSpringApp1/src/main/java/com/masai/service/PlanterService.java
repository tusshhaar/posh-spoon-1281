package com.masai.service;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlanterException;
import com.masai.model.Planter;

public interface PlanterService {

	public Planter addPlanter(String uuid,Planter planter) throws PlanterException,AdminException;
	
	public Planter updatePlanter(String uuid,Planter planter) throws PlanterException,AdminException;
	
	public Planter deletePlanter (String uuid,Integer planterId) throws PlanterException,AdminException;
	
	public Planter viewPlanter(String uuid,Integer planterId) throws PlanterException,CustomerException;
	
	public Planter viewPlanterByShape(String uuid,String planterShape) throws PlanterException,CustomerException;
	
	public List<Planter> viewAllPlanters(String uuid) throws PlanterException,CustomerException;
	
	public List<Planter> viewAllPlanters(String uuid,Double minCost,Double maxCost) throws PlanterException,CustomerException;
}
