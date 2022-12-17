package com.masai.service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.exception.PlanterException;
import com.masai.exception.SeedException;
import com.masai.model.CustomerCurrentUserSession;
import com.masai.model.ItemOrder;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.CustomerSessionRepo;
import com.masai.repository.ItemOrderRepo;
import com.masai.repository.PlantDao;
import com.masai.repository.PlanterRepo;
import com.masai.repository.SeedRepo;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
	
	@Autowired
	private ItemOrderRepo iRepo;
	
	@Autowired
	private PlanterRepo pRepo;
	
	@Autowired
	private PlantDao pDao;
	
	@Autowired
	private SeedRepo sRepo;
	
	@Autowired
	private CustomerSessionRepo cSessionRepo;

	@Override
	public List<Planter> findSeedWithPlanter(String seed, String key) throws OrderException, CustomerException, PlanterException {

		 CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
		 
		 if(session!=null) {
			 
			 List<Planter> planters = pRepo.getPlanterBySeed(seed);
			 
			 if(planters.size()==0) {
				 
				 throw new PlanterException(seed+"seed is not available");
			 }else
				 
				 return planters;
		 }else
			 
			 throw new CustomerException("Please enter valid key");
	}

	@Override
	public List<Planter> findPlantWithPlanter(String plantName, String key) throws OrderException, CustomerException, PlanterException {
		
		CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
		
		
		 if(session!=null) {
			 
			 List<Planter> planters = pRepo.getPlanterByPlant(plantName);
			 
			 if(planters.size()==0) {
				 
				 throw new PlanterException(plantName+"plant is not available");
			 }else
				 
				 return planters;
		 }else
			 
			 throw new CustomerException("Please enter valid key");
		
		
	}

	@Override
	public String buyPlanterWithSeed(ItemOrder order, String key, Integer planterId) throws CustomerException, PlanterException {
		
	  CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
	  
	  if(session!=null) {
		  
		  Optional<Planter> planter = pRepo.findById(planterId);
		  
		  Planter planter2 = planter.get();
		  
		  if(planter2==null) {
			  
			  throw new PlanterException("Please enter valid Planter Id");
		  }else {
			  
			  if(planter2.getSeed()!=null) {
				  if(order.getQuantity() <= planter2.getPlanterStock()) {
						
					  order.setLocalDateTime(LocalDateTime.now());
					  
					  order.setTotalCost((planter2.getPlanterCost()+planter2.getSeed().getSeedsCost())*order.getQuantity());
					  
					  planter2.setPlanterStock(planter2.getPlanterStock() - order.getQuantity());
					  
					  iRepo.save(order);
					  
					  return order.toString() + " " + planter2.toString();
					  
				  }else
					  
					  throw new PlanterException("Planter is out of Stock");
			  }else
				  
				  throw new PlanterException("There is no seed available with planterId :"+planterId);
		  }
		  
	  }else
		  
		  throw new CustomerException("Please enter valid key or login first");
		
	}

	@Override
	public String buyPlanterWithPlant(ItemOrder order, String key, Integer planterId) throws CustomerException, PlanterException {
		
		  CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
		  
		  if(session!=null) {
			  
			  Optional<Planter> planter = pRepo.findById(planterId);
			  
			  Planter planter2 = planter.get();
			  
			  if(planter2==null) { 
				  throw new PlanterException("Please enter valid Planter Id");
			  }else {
				  
				  if(planter2.getPlant()!=null) {
					  if(order.getQuantity() <= planter2.getPlanterStock()) {
							
						  order.setLocalDateTime(LocalDateTime.now());
						  
						  order.setTotalCost((planter2.getPlanterCost()+planter2.getSeed().getSeedsCost())*order.getQuantity());
						  
						  planter2.setPlanterStock(planter2.getPlanterStock() - order.getQuantity());
						  
						  pRepo.save(planter2);
						  
						  iRepo.save(order);
						  
						  return order.toString() + " " + planter2.toString();
						  
					  }else
						  
						  throw new PlanterException("Planter is out of Stock");
				  }else
					  
					  throw new PlanterException("There is no plant available with planter Id :"+planterId);
			  }
			  
		  }else
			  
			  throw new CustomerException("Please enter valid key or login first");
	}

	
	@Override
	public String buyPlanterBYShapeAndId(ItemOrder order, String key, String shape, Integer planterId) throws CustomerException, PlanterException {
		
		CustomerCurrentUserSession customerSession = cSessionRepo.findByCustomerUuid(key);
		
		if(customerSession!=null) {
			
			Optional<Planter> opt = pRepo.findById(planterId);

			if(opt.isPresent()) {
				
				Planter planter = opt.get();
				
				if(planter.getPlanterShape().equals(shape)) {
					
					order.setLocalDateTime(LocalDateTime.now());
					
					order.setTotalCost(planter.getPlanterCost()*order.getQuantity());
					
					planter.setPlanterStock(planter.getPlanterStock() - order.getQuantity());
					
					pRepo.save(planter);
					
					iRepo.save(order);
					
					return order.toString() + "      =======================      " + planter.toString();
					
				}else
					
					throw new PlanterException("Planter not found with shape :"+shape);
				
				
			}else {
				throw new PlanterException("There is no planter available with id :"+planterId);
			}
			
		}else
			
			throw new CustomerException("Invalid key. Please enter valid key or login first");
		
	}


	@Override
	public List<Plant> viewPlantByName(String key, String name) throws CustomerException, PlanterException {

		CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
		
		if(session!=null) {
			
			List<Plant> plants = pDao.findByCommonName(name);
			
			if(plants.isEmpty()) {
				
				throw new PlanterException("No plant available with name :"+name);
				
			}else
				
				return plants;
			
		}else
			
			throw new CustomerException("Please enter valid key");
		
		

		
	}

	@Override
	public String buyPlantWithNameAndId(ItemOrder order, String name, Integer id, String key) throws CustomerException, PlanterException {
		
		CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
		
		if(session!=null) {
			
			Optional<Plant> opt = pDao.findById(id);
			
			if(opt.isPresent()) {
				
				Plant plant = opt.get();
				
				if(plant.getCommonName().equals(name)) {
					
					order.setLocalDateTime(LocalDateTime.now());
					
					order.setTotalCost(plant.getPlantCost()*order.getQuantity());
					
					plant.setPlantsStock(plant.getPlantsStock() - order.getQuantity());
					
					pDao.save(plant);
					
					iRepo.save(order);
					
					return order.toString() + "      =======================      " + plant.toString();
					
				}else
					
					throw new PlanterException("No Plant is available with name :"+name);
				
			}else
				
				throw new PlanterException("No Plant is available with Id :"+id);
			
		}else
			
			throw new CustomerException("Please enter valid key");
		
		
	}

	@Override
	public String buySeedWithName(ItemOrder order, String name, String key) throws CustomerException, SeedException {

		CustomerCurrentUserSession session = cSessionRepo.findByCustomerUuid(key);
		
		if(session!=null) {
			
			Seed seed = sRepo.findByCommanName(name);
			
			if(seed!=null) {
				
				if(order.getQuantity()<=seed.getSeedStock()) {
					
					order.setLocalDateTime(LocalDateTime.now());
					
					order.setTotalCost(seed.getSeedsCost()*order.getQuantity());
					
					seed.setSeedStock(seed.getSeedStock() - order.getQuantity());
					
					sRepo.save(seed);
					
					iRepo.save(order);
					
					return order.toString() + "       ==============      " + seed.toString();
					
				}else
					
					throw new SeedException("Seed is out of Stock");
				
			}else
				
				throw new SeedException("There is no seed available with name :"+name);
			
		}else
			
			throw new CustomerException("Please enter valid key");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
