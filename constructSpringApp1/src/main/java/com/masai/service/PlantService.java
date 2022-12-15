package com.masai.service;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.PlantException;
import com.masai.model.Plant;



public interface PlantService {
public Plant addPlant(String uuid,Plant plant) throws PlantException,AdminException;
	
	public Plant updatePlant(String uuid,Plant plant) throws PlantException,AdminException;
	
	public Plant deletePlant (String uuid,Integer plantId) throws PlantException,AdminException;
	
	public Plant viewPlant(String uuid,Integer plantId) throws PlantException,AdminException;
	
	public Plant viewPlantByName(String uuid,String commonName) throws PlantException,AdminException;
	
	public List<Plant> viewAllPlants() throws PlantException;
	
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException;
}
