package com.masai.service;


import com.masai.exception.PlantNotFoundException;
import com.masai.model.Plant;

import java.util.List;

public interface PlantService{

    public Plant addPlant(Plant plant);

    public Plant updatePlant(Plant plant) throws PlantNotFoundException;

    public Plant deletePlantById(Integer plantId) throws PlantNotFoundException;

    public Plant viewPlantById(Integer plantId) throws PlantNotFoundException;

    public List<Plant> viewPlantByName(String name) throws PlantNotFoundException;

    public List<Plant> viewAllPlants() throws PlantNotFoundException;

    public List<Plant> viewPlantsByPlantType(String type) throws PlantNotFoundException;
}
