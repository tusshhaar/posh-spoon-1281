package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;
	private LocalDateTime localDateTime;
	private String transactionMode;
	private Integer quantity;
	private Double totalCost;
	
	@OneToMany
	private List<Planter> planters;
	
	@OneToMany
	private List<Seed> seeds;
	
	@OneToMany
	private List<Plant> plants;

}
