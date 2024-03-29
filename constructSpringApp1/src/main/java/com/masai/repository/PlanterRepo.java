package com.masai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Planter;

@Repository
public interface PlanterRepo extends JpaRepository<Planter, Integer>{
	
	public List<Planter> findByPlanterShape(String planterShape);
	
	@Query("Select p from Planter p where p.planterCost between :min and :max")
	public List<Planter> findByPlanterBetweenMinAndMax(@Param("min") Double min,@Param("max") Double max);
	
	
	@Query("select p from Planter p where p.seed.commanName = ?1")
	public List<Planter> getPlanterBySeed(String seed);
	
	@Query("select p from Planter p where p.plant.commonName = ?1")
	public List<Planter> getPlanterByPlant(String plantName);

}
