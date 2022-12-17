package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminLoginException;
import com.masai.exception.SeedException;
import com.masai.model.AdminCurrentUserSession;
import com.masai.model.Seed;
import com.masai.service.SeedServices;

@RestController
public class SeedController {

	@Autowired
	SeedServices seedServices;
	
	
	@PostMapping("/seed/{key}")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed, @PathVariable("key") String key) throws SeedException, AdminLoginException{
	 Seed seed2=	seedServices.addSeed(seed,key);
		return new ResponseEntity<>(seed2,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get/{id}/{key}")
	public ResponseEntity<Seed> getSeedByRoll(@PathVariable("id") Integer id,@PathVariable("key") String key) throws SeedException, AdminLoginException{
		Seed seed=seedServices.viewSeed(id,key);
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll/{key}")
	public ResponseEntity<List<Seed>> getAllSeed(@PathVariable("key")String key) throws SeedException, AdminLoginException{
		List<Seed> list=seedServices.viewAllSeeds(key);
		return new ResponseEntity<List<Seed>>(list,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}/{key}")
	public ResponseEntity<Seed> delete(@PathVariable("id") Integer id,@PathVariable("key")String key) throws SeedException, AdminLoginException{
	Seed seed=	seedServices.deleteSeed(id,key);
	return new ResponseEntity<Seed>(seed,HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed,@PathVariable String key) throws SeedException, AdminLoginException{
	Seed seed1=	seedServices.updateSeed(seed,key);
	return new ResponseEntity<Seed>(seed1,HttpStatus.OK);
	}
	
	@GetMapping("/byName/{name}/{key}")
	public ResponseEntity<Seed> byName(@PathVariable("name") String name,@PathVariable("key") String key) throws SeedException, AdminLoginException{
		
	Seed seed=seedServices.viewSeed(name,key);
	return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	
	}
	
	@GetMapping("/byType/{type}/{key}")
	public ResponseEntity<List<Seed>>byType(@PathVariable("type") String name, @PathVariable("key") String key) throws SeedException, AdminLoginException{
		List<Seed> seed=seedServices.viewAllSeeds(name,key);
		return new ResponseEntity<List<Seed>>(seed,HttpStatus.OK);
		
	}
	
}
