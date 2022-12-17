package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Seed;

@Repository
public interface SeedRepo extends JpaRepository<Seed, Integer>{
	
	public Seed findByCommanName(String commanName);
	public List<Seed> findByTypeOfSeed(String typeOfSeed);
	
}
