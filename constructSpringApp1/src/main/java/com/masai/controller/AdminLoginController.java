package com.masai.controller;

import java.util.List;

import com.masai.exception.*;
import com.masai.model.Plant;
import com.masai.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.exception.SeedException;
import com.masai.model.AdminLoginDTO;
import com.masai.model.Customer;
import com.masai.model.Seed;
import com.masai.service.AdminLoginService;
import com.masai.service.SeedServices;

import com.masai.model.Planter;
import com.masai.service.PlanterService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService aLoginService;

	@Autowired
	private SeedServices seedServices;


	@Autowired
	private PlanterService pService;

	@Autowired
	private PlantService plantService;
	

	@GetMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLoginDTO loginDTO) throws AdminLoginException{
		
		String str = aLoginService.adminLoginDTO(loginDTO);
		
		return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
	}
	
	//Admin Logout-----------------------------
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> adminLogout(@Valid @PathVariable("key") String key) throws AdminLoginException{
		
		String str = aLoginService.adminLogoutDTO(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	//----------------------------------------------------Customer Action Perform By Admin-------------------------------------------
	
	
	//View Customer List ----------------------------------
	
	@GetMapping("/customers/{key}")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("key") String key) throws CustomerException{
		
		List<Customer> customers = aLoginService.viewAllCustomers(key);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	//Delete Customer By Id ------------------------------------
	
	@DeleteMapping("/customer/{id}/{key}")
	public ResponseEntity<Customer> removeCustomerById(@PathVariable("id") Integer customerId,@PathVariable("key") String key) throws AdminLoginException, CustomerException{
		
		Customer customer = aLoginService.removeCustomerById(customerId, key);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	
	
	//-------------------------------------------------Seed Action Perform By Admin-------------------------------------------------
	
	
	
	
	//Add Seed --------------------------------------------
	
	@PostMapping("/seed/{key}")
	public ResponseEntity<Seed> addSeedHandler(@RequestBody Seed seed, @PathVariable("key") String key) throws SeedException, AdminLoginException{
		
		Seed obj=seedServices.addSeed(seed, key);
		
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
		
	}
	
	//Update Seed ------------------------------------
	
	@PutMapping("/seed/{key}")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed,@PathVariable String key) throws SeedException, AdminLoginException{
	
		Seed seed1=	seedServices.updateSeed(seed,key);
		
	    return new ResponseEntity<Seed>(seed1,HttpStatus.OK);
	}
	
	//Delete Seed -----------------------------------
	
	@DeleteMapping("/seed/{id}/{key}")
	public ResponseEntity<Seed> delete(@PathVariable("id") Integer id,@PathVariable("key")String key) throws SeedException, AdminLoginException{
	 
		Seed seed=	seedServices.deleteSeed(id,key);
	
		return new ResponseEntity<Seed>(seed,HttpStatus.OK); 
	}
	
	
	
	
	//------------------------------------------------------Planter Action Perform By Admin---------------------------------------------
	
	
	
	
	//Add Planter -----------------------------------

    @PostMapping("/planter/{key}")
	public ResponseEntity<Planter> addPlanterHandler(@PathVariable("key")String uuid,@RequestBody Planter planter) throws PlanterException, AdminException{
		
    	Planter register = pService.addPlanter(uuid, planter);
		
    	return new ResponseEntity<Planter>(register,HttpStatus.ACCEPTED);
	}
    
    //Update Planter ------------------------------
	
	@PutMapping("/planter/{key}")
	public ResponseEntity<Planter> updatePlanterHandler(@PathVariable("key")String uuid,@RequestBody Planter planter) throws PlanterException, AdminException{
		
		Planter update = pService.updatePlanter(uuid, planter);
		
		return new ResponseEntity<Planter>(update,HttpStatus.OK);
	}
	
	// Delete Planter ----------------------------------
	
	@DeleteMapping("/planter/{planterId}/{loginId}")
	public ResponseEntity<Planter> deletePlanterHandler(@PathVariable("loginId")String uuid,@PathVariable Integer planterId) throws PlanterException, AdminException{
		
		Planter planter = pService.deletePlanter(uuid, planterId);
		
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	


	/*---------------------------------------------------------------------Plant Action Perform By Admin-------------------------------------------------------------------*/
	
	
	
	// Add plant

	@PostMapping("/plant/{key}")
	public ResponseEntity<Plant> addPlantHandler(@RequestBody Plant plant, @PathVariable("key") String key) throws PlantNotFoundException, AdminLoginException {

		Plant pObj = plantService.addPlant(plant,key);

		return new ResponseEntity<Plant>(pObj, HttpStatus.CREATED);


	}

	// Update plant

	@PutMapping("/plant/{key}")
	public ResponseEntity<Plant> updatePlantHandler(@PathVariable("key") String key,@RequestBody Plant plant) throws PlantNotFoundException, AdminLoginException {

		Plant pObj = plantService.updatePlant(plant,key);

		return new ResponseEntity<Plant>(pObj, HttpStatus.ACCEPTED);


	}

	// Delete plant

	@DeleteMapping("/plant/{id}/{key}")
	public ResponseEntity<Plant> deletePlantByIdHandler(@PathVariable("key") String key,@PathVariable("id") Integer plantId) throws PlantNotFoundException, AdminLoginException {


		Plant plant = plantService.deletePlantById(plantId,key);

		return new ResponseEntity<Plant>(plant, HttpStatus.OK);


	}

	

}
