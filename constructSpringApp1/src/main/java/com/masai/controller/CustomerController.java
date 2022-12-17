

package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.exception.PlanterException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginDTO;
import com.masai.model.ItemOrder;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.repository.PlantDao;
import com.masai.service.CustomerService;
import com.masai.service.ItemOrderService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private ItemOrderService iService;
	
	@PutMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer c1) throws CustomerException{
		
		Customer customer = cService.registerCustomer(c1);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody CustomerLoginDTO dto) throws CustomerException{
		
		String str = cService.loginCustomer(dto);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam("key") String key) throws CustomerException{
		
		String str = cService.logoutCustomer(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@PutMapping("/update/{key}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("key") String key) throws CustomerException{
		
		Customer updateCustomer = cService.upDateCustomer(customer, key);
		
		return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/profile/{id}")
	public ResponseEntity<Customer> viewProfile(@PathVariable("id") Integer id) throws CustomerException{
		
		Customer customer = cService.seeProfile(id);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/seedWithPlanter/{seed}/{key}")
	public ResponseEntity<List<Planter>> getPlanterWithSeed(@PathVariable("seed") String seed, @PathVariable("key") String key) throws OrderException, CustomerException, PlanterException{
		
		List<Planter> planters = iService.findSeedWithPlanter(seed, key);
		
		return new ResponseEntity<List<Planter>>(planters, HttpStatus.OK);
	}
	
	@GetMapping("/planterWithSeed/buy/{planterId}/{key}")
	public ResponseEntity<String> buyPlanterWithSeed(@RequestBody ItemOrder order, @PathVariable("key") String key, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterException{
		
		String str = iService.buyPlanterWithSeed(order, key, planterId);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/planterByShapeAndId/{planterId}/{shape}/{key}")
	public ResponseEntity<Planter> buyPlanterByShape(@PathVariable("key") String key,@PathVariable("shape") String shape, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterException{
		
		Planter planters = iService.buyPlanterBYShapeAndId(key, shape, planterId);
		
		return new ResponseEntity<Planter>(planters, HttpStatus.OK);
	}
	
	@GetMapping("plantName/{name}/{key}")
	public ResponseEntity<List<Plant>> buyPlantByCommonName(@PathVariable("key") String key, @PathVariable("name") String name) throws CustomerException, PlanterException{
		
		List<Plant> plants = iService.viewPlantByName(key, name);
		
		return new ResponseEntity<List<Plant>>(plants, HttpStatus.OK);
	}
	
	@GetMapping("/plant/buy/{id}/{name}/{key}")
	public ResponseEntity<Plant> buyPlantWithNameAndId(@PathVariable("name") String name, @PathVariable("id") Integer id, @PathVariable("key") String key) throws CustomerException, PlanterException{
		
		Plant plant = iService.buyPlantWithNameAndId(name, id, key);
		
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
