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

import com.masai.exception.AdminException;
import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlanterException;
import com.masai.model.AdminLoginDTO;
import com.masai.model.Customer;
import com.masai.model.OrderTable;
import com.masai.model.Planter;
import com.masai.service.AdminLoginService;
import com.masai.service.OrderService;
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
	private OrderService oService;
	
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
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("loginId")String uuid,@PathVariable Integer planterId) throws PlanterException, AdminException{
		Planter planter = pService.viewPlanter(uuid,planterId);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}/planter/{shape}")
	public ResponseEntity<Planter> getPlanterByShapeHandler(@PathVariable("loginId")String uuid, @PathVariable("shape")String shape) throws PlanterException, AdminException{
		Planter planter = pService.viewPlanterByShape(uuid,shape);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getPlantersHandler(){
		List<Planter> planters = pService.viewAllPlanters();
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	@GetMapping("/planter/{min}/{max}")
	public ResponseEntity<List<Planter>> getPlantersByCostRangeHandler(@PathVariable("min")Double min,@PathVariable("max")Double max){
		List<Planter> planter = pService.viewAllPlanters(min, max);
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}
	
	@PostMapping("/order/{key}")
	public ResponseEntity<String> addOrder(@RequestBody OrderTable order, @PathVariable("key") String key) throws AdminLoginException{
		
		String str = oService.addPlanter(order, key);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
