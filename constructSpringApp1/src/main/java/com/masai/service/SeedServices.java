package com.masai.service;

import java.util.List;

import com.masai.model.Seed;

public interface SeedServices {
	public Seed addSeed(Seed seed);
	public Seed updateSeed(Seed seed);
	public Seed deleteSeed(Seed seed);
	public Seed viewSeed(Integer id);
	public Seed viewSeed(String CommanName);
	public List<Seed> viewAllSeed();
	public List<Seed> viewAllSeeds(String TypeOfSeed);
	
}
