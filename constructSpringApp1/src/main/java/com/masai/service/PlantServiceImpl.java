package com.masai.service;


import com.masai.exception.PlantNotFoundException;
import com.masai.model.Plant;
import com.masai.repository.PlantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {


	@Autowired
	private PlantDao pdao;

	@Override
	public Plant addPlant(Plant plant) {
	  Plant plants=	pdao.save(plant);
		return plants;
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantNotFoundException {
		Optional<Plant> opt = pdao.findById(plant.getPlantId());

		if (opt.isPresent()) {

			return pdao.save(plant);

		} else {
			throw new PlantNotFoundException("No plant found with this Plant Id :");
		}
	}

	@Override
	public Plant deletePlantById(Integer plantId) throws PlantNotFoundException {
		Optional<Plant> opt = pdao.findById(plantId);

		if (opt.isPresent()) {
			Plant plant = opt.get();
			pdao.delete(plant);
			return plant;
		} else {
			throw new PlantNotFoundException("No plant present with this Plant Id :"+plantId);
		}
	}

	@Override
	public Plant viewPlantById(Integer plantId) throws PlantNotFoundException {

		Optional<Plant> plant = pdao.findById(plantId);

		if (plant.isPresent()) {

			return plant.get();

		} else {
			throw new PlantNotFoundException("Plant does not exist with this Plant Id :"+plantId);
		}
	}

	@Override
	public List<Plant> viewPlantByName(String name) throws PlantNotFoundException {
		List<Plant> list = pdao.findByCommonName(name);

		if (list.isEmpty()) {

			throw new PlantNotFoundException("Plant does not exist with this Name :"+name);
		} else {
			return list;
		}
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantNotFoundException {
		List<Plant> list = pdao.findAll();

		if (list.isEmpty()) {
			throw new PlantNotFoundException("No plant found...");
		} else {
			return list;
		}
	}

	@Override
	public List<Plant> viewPlantsByPlantType(String type) throws PlantNotFoundException {
		List<Plant> list = pdao.findByTypeOfPlant(type);

		if (list.isEmpty()) {

			throw new PlantNotFoundException("No Plants exist with Plant Type :"+type);
		} else {

			return list;
		}
	}
}
