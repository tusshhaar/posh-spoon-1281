package com.masai.repository;

import com.masai.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantDao extends JpaRepository<Plant,Integer> {

    public List<Plant> findByCommonName(String name);

    public List<Plant> findByTypeOfPlant(String type);

}
