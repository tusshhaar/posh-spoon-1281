package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private Seed seed;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Plant plant;
}