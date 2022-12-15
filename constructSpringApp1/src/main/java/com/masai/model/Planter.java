package com.masai.model;

import jakarta.persistence.Entity;
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
	private Integer planterId;
	private float planterheight;
	private Integer planterCapacity;
	private Integer drainageHoles;
	private Integer planterColor;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;
	private Plant plant;
}