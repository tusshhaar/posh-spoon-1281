package com.masai.service;

import java.util.List;

import com.masai.exception.AdminLoginException;
import com.masai.exception.SeedException;
import com.masai.model.Seed;

public interface SeedServices{
	
	public Seed addSeed(Seed seed,String key) throws SeedException,AdminLoginException;
	
	public Seed updateSeed(Seed seed,String key)throws SeedException,AdminLoginException;
	
	public Seed deleteSeed(Integer id,String key)throws SeedException,AdminLoginException;
	
	public Seed viewSeed(Integer id,String Key)throws SeedException,AdminLoginException;
	
	public Seed viewSeed(String commanName, String Key)throws SeedException,AdminLoginException;
	
	public List<Seed> viewAllSeeds(String Key)throws SeedException,AdminLoginException;
	
	public List<Seed> viewAllSeeds(String typeOfSeed, String Key)throws SeedException,AdminLoginException;
	
}
