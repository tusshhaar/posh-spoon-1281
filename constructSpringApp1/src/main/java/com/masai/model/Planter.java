package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@NotNull(message = "Planter height should not be null")
	@Min(value = 1, message = "Planter height is must be greater than equal to 1")
	private float planterheight;
	@NotNull(message = "Planter capacity should not be null")
	@Min(value = 1, message = "Planter capacity is must be greater than equal to 1")
	private Integer planterCapacity;
	@NotNull(message = "Planter Holes should not be null")
	@Min(value = 1, message = "Planter holes is must be greater than equal to 1")
	private Integer drainageHoles;
	@NotNull(message = "Planter Color should not be null")
	private Integer planterColor;
	@NotNull(message = "Planter Shape should not be null")
	private String planterShape;
	@NotNull(message = "Planter Stock should not be null")
	@Min(value = 0, message = "Planter stock is must be greater than equal to 1")
	private Integer planterStock;
	@NotNull(message = "Planter Cost should not be null")
	@Min(value = 1, message = "Planter cost is must be greater than equal to 1")
	private Double planterCost;
	

	@OneToOne(cascade = CascadeType.ALL)
	private Seed seed;

	@OneToOne(cascade = CascadeType.ALL)
	private Plant plant;
}