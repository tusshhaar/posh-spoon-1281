package com.masai.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	private float planterheight;
	private Integer planterCapacity;
	private Integer drainageHoles;
	private Integer planterColor;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;
	
//	private Set<Plant> setPlant;
//	private Set<Seed> setSeed;
}