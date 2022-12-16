package com.masai.model;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	
	private LocalDateTime localDateTime;
	private String transactionMode;
	private Integer quantity;
	private Double totalCost;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters;
	
}
