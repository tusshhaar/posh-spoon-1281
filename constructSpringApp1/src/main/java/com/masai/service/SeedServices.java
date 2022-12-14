package com.masai.service;

import java.util.List;

import com.masai.model.Seed;

public interface SeedServices {
	public Seed addSeed(Seed seed);
	public Seed updateSeed(Seed seed);
	public Seed deleteSeed(Seed seed);
	public Seed viewSeed(Integer id);
	public Seed viewSeed(String commanName);
	public List<Seed> viewAllSeeds();
	public List<Seed> viewAllSeeds(String TypeOfSeed);
	
}
