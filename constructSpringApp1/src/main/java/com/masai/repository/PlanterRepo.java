package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.model.Planter;

public interface PlanterRepo extends JpaRepository<Planter, Integer>{
	
	public Optional<Planter> findByPlanterShape(String planterShape);
	
	@Query("select p from Planter p where p.planterCost between :min and :max")
	public List<Planter> findByPlanterBetweenMinAndMax(@Param("min") Double min,@Param("max") Double max);
	
}
