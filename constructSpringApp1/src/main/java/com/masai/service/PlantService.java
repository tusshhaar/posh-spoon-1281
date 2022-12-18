package com.masai.service;


import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlantNotFoundException;
import com.masai.exception.PlanterException;
import com.masai.model.Plant;

import java.util.List;

public interface PlantService{

    public Plant addPlant(Plant plant, String key) throws AdminLoginException;

    public Plant updatePlant(Plant plant,String key) throws PlantNotFoundException,AdminLoginException;

    public Plant deletePlantById(Integer plantId,String key) throws PlantNotFoundException,AdminLoginException;

    public Plant viewPlantById(Integer plantId, String uuid) throws PlantNotFoundException, CustomerException, PlanterException;

    public List<Plant> viewPlantByName(String name) throws PlantNotFoundException;

    public List<Plant> viewAllPlants() throws PlantNotFoundException;

    public List<Plant> viewPlantsByPlantType(String type) throws PlantNotFoundException;
}
