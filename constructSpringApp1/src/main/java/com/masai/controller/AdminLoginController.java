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

import com.masai.model.AdminLoginDTO;
import com.masai.model.Customer;
import com.masai.model.Planter;
import com.masai.service.AdminLoginService;
import com.masai.service.PlanterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService aLoginService;

	@Autowired
	private PlanterService pService;

	@Autowired
	private PlantService plantService;
	
	@GetMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLoginDTO loginDTO) throws AdminLoginException{
		
		String str = aLoginService.adminLoginDTO(loginDTO);
		
		return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> adminLogout(@Valid @RequestParam("key") String key) throws AdminLoginException{
		
		String str = aLoginService.adminLogoutDTO(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/customers/{key}")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("key") String key) throws CustomerException{
		
		List<Customer> customers = aLoginService.viewAllCustomers(key);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

    @PostMapping("/{loginId}/planter")
	public ResponseEntity<Planter> addPlanterHandler(@PathVariable("loginId")String uuid,@RequestBody Planter planter) throws PlanterException, AdminException{
		Planter register = pService.addPlanter(uuid, planter);
		return new ResponseEntity<Planter>(register,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{loginId}/planter")
	public ResponseEntity<Planter> updatePlanterHandler(@PathVariable("loginId")String uuid,@RequestBody Planter planter) throws PlanterException, AdminException{
		Planter update = pService.updatePlanter(uuid, planter);
		return new ResponseEntity<Planter>(update,HttpStatus.OK);
	}
	
	@DeleteMapping("/{loginId}/planter/{planterId}")
	public ResponseEntity<Planter> deletePlanterHandler(@PathVariable("loginId")String uuid,@PathVariable Integer planterId) throws PlanterException, AdminException{
		Planter planter = pService.deletePlanter(uuid, planterId);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}/planter/{planterId}")
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("loginId")String uuid,@PathVariable Integer planterId) throws PlanterException, AdminException, CustomerException{
		Planter planter = pService.viewPlanter(uuid,planterId);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}/planter/{shape}")
	public ResponseEntity<Planter> getPlanterByShapeHandler(@PathVariable("loginId")String uuid, @PathVariable("shape")String shape) throws PlanterException, AdminException, CustomerException{
		Planter planter = pService.viewPlanterByShape(uuid,shape);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getPlantersHandler(String uuid) throws PlanterException, CustomerException{
		
		List<Planter> planters = pService.viewAllPlanters(uuid);
		
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	@GetMapping("/planter/{min}/{max}")
	public ResponseEntity<List<Planter>> getPlantersByCostRangeHandler(String uuid,@PathVariable("min")Double min,@PathVariable("max")Double max) throws PlanterException, CustomerException{
		List<Planter> planter = pService.viewAllPlanters(uuid,min, max);
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}



	/*---------------------------------------------------------------------Plant Section-------------------------------------------------------------------*/
	// Add plant

	@PostMapping("/plants/{key}")
	public ResponseEntity<Plant> addPlantHandler(@RequestBody Plant plant, @PathVariable("key") String key) throws PlantNotFoundException, AdminLoginException {

		Plant pObj = plantService.addPlant(plant,"key");

		return new ResponseEntity<Plant>(pObj, HttpStatus.CREATED);


	}

	// Updating existing plant details

	@PutMapping("/plants/{key}")
	public ResponseEntity<Plant> updatePlantHandler(@PathVariable("key") String key,@RequestBody Plant plant) throws PlantNotFoundException, AdminLoginException {

		Plant pObj = plantService.updatePlant(plant,key);

		return new ResponseEntity<Plant>(pObj, HttpStatus.ACCEPTED);


	}

	// Delete existing plant by PlantId

	@DeleteMapping("/plants/{key}/{id}")
	public ResponseEntity<Plant> deletePlantByIdHandler(@PathVariable("key") String key,@PathVariable("id") Integer plantId) throws PlantNotFoundException, AdminLoginException {


		Plant plant = plantService.deletePlantById(plantId,key);

		return new ResponseEntity<Plant>(plant, HttpStatus.OK);


	}

	/*---------------------------------------------------------------------**Plant Section End**---------------------------------------------------------------*/
}
