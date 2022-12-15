package com.masai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.model.Plant;

public interface PlantRepo extends JpaRepository<Plant, Integer>{
		public Plant findByCommonName(String commonName);
		
		public List<Plant> findByTypeOfPlant(String typeOfPlant);
}
