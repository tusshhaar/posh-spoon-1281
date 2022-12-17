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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlanterException;
import com.masai.model.Planter;
import com.masai.service.PlanterService;
import com.masai.service.PlanterServiceImp;

@RestController
public class AdminController {
	
	@Autowired
	private PlanterService pService;
	
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
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("loginId")String uuid,@PathVariable Integer planterId) throws PlanterException, CustomerException {
		Planter planter = pService.viewPlanter(uuid,planterId);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}/planter/{shape}")
	public ResponseEntity<List<Planter>> getPlanterByShapeHandler(@PathVariable("loginId")String uuid, @PathVariable("shape")String shape) throws PlanterException, CustomerException{
		List<Planter> planter = pService.viewPlanterByShape(uuid,shape);
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}/planters")
	public ResponseEntity<List<Planter>> getPlantersHandler(@PathVariable("loginId")String uuid) throws PlanterException, CustomerException {
		List<Planter> planters = pService.viewAllPlanters(uuid);
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}/planter/{min}/{max}")
	public ResponseEntity<List<Planter>> getPlantersByCostRangeHandler(@PathVariable("loginId")String uuid,@PathVariable("min")Double min,@PathVariable("max")Double max) throws PlanterException, CustomerException {
		List<Planter> planter = pService.viewAllPlanters(uuid,min, max);
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}
}
