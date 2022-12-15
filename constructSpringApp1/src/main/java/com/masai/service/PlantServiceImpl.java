package com.masai.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.AdminException;
import com.masai.exception.PlantException;
import com.masai.model.AdminCurrentUserSession;
import com.masai.model.Plant;
import com.masai.repository.AdminSessionRepo;
import com.masai.repository.PlantRepo;


@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private AdminSessionRepo loginDao;
	
	@Autowired
	private PlantRepo plantDao;

	@Override
	public Plant addPlant(String uuid, Plant plant) throws PlantException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Plant saved = plantDao.save(plant);
		if(saved==null) {
			throw new PlantException("Not able to add Plant please check details");
		}return saved;
	}

	@Override
	public Plant updatePlant(String uuid, Plant plant) throws PlantException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Optional<Plant> opt = plantDao.findById(plant.getPlantId());
		Plant updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			updated=plant;
			return plantDao.save(updated);
		}else {
			throw new PlantException("Plant not found with id : "+plant.getPlantId());
		}
	}

	@Override
	public Plant deletePlant(String uuid, Integer plantId) throws PlantException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Optional<Plant> opt = plantDao.findById(plantId);
		Plant updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			plantDao.delete(updated);
			return updated;
		}else {
			throw new PlantException("Plant not found with id : "+plantId);
		}
	}

	@Override
	public Plant viewPlant(String uuid, Integer plantId) throws PlantException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Optional<Plant> opt =plantDao.findById(plantId);
		Plant updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			return updated;
		}else {
			throw new PlantException("Plant not found with Id : "+plantId);
		}
	}

	@Override
	public Plant viewPlantByName(String uuid, String commonName) throws PlantException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			
			throw new AdminException("Please Login as Admin");
		}
		Plant updated =plantDao.findByCommonName(commonName);
		if(updated==null) {
			throw new PlantException("Plant not found with Common Name : "+commonName);
		}
		return updated;
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		List<Plant> list = plantDao.findAll();
		if(list.size()==0) {
			throw new PlantException("There are no Plants available");
		}
		return list;
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException {
		List<Plant> list = plantDao.findByTypeOfPlant(typeOfPlant);
		if(list.size()==0) {
			throw new PlantException("There are no Plants available");
		}
		return list;
	}
}
