

package com.masai.controller;

import java.util.List;

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

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.exception.PlanterException;
import com.masai.exception.SeedException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginDTO;
import com.masai.model.ItemOrder;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.service.CustomerService;
import com.masai.service.ItemOrderService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private ItemOrderService iService;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer c1) throws CustomerException{
		
		Customer customer = cService.registerCustomer(c1);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/login")
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
	
	@PostMapping("/planterWithSeed/buy/{planterId}/{key}")
	public ResponseEntity<String> buyPlanterWithSeed(@RequestBody ItemOrder order, @PathVariable("key") String key, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterException{
		
		String str = iService.buyPlanterWithSeed(order, key, planterId);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);

	}
	
	@PostMapping("/planterByShapeAndId/{planterId}/{shape}/{key}")
	public ResponseEntity<String> buyPlanterByShape(ItemOrder order, @PathVariable("key") String key,@PathVariable("shape") String shape, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterException{
		
		String planters = iService.buyPlanterBYShapeAndId(order, key, shape, planterId);
		
		return new ResponseEntity<String>(planters, HttpStatus.OK);
	}
	
	@GetMapping("plantName/{name}/{key}")
	public ResponseEntity<List<Plant>> buyPlantByCommonName(@PathVariable("key") String key, @PathVariable("name") String name) throws CustomerException, PlanterException{
		
		List<Plant> plants = iService.viewPlantByName(key, name);
		
		return new ResponseEntity<List<Plant>>(plants, HttpStatus.OK);
	}
	
	@PutMapping("/seed/buy/{name}/{key}")
	public ResponseEntity<String> buySeedWithName(@RequestBody ItemOrder order, @PathVariable("name") String name, @PathVariable("key") String key) throws CustomerException, SeedException{
		
		String str = iService.buySeedWithName(order, name, key);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/planter/buy/{planterId}/{shape}/{key}")
	public ResponseEntity<String> buyPlanterBYShapeAndId(@RequestBody ItemOrder order, @PathVariable("key") String key, @PathVariable("shape") String shape, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterException {
		
		String str = iService.buyPlanterBYShapeAndId(order, key, shape, planterId);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/cart/{key}")
	public ResponseEntity<Cart> viewCart(@PathVariable("key") String key) throws OrderException{
	
		Cart cart = iService.viewCart(key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/cart/{bookingId}/{key}")
	public ResponseEntity<String> deleteItemFromCart(@PathVariable("bookingId") Integer bookingId, @PathVariable("key") String key) throws OrderException, CustomerException{
		
		String str = iService.deleteItemFromCart(bookingId, key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
