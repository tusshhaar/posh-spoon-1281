package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;
	private LocalDateTime localDateTime;
	private String transactionMode;
	private Integer quantity;
	private Double totalCost;
	
}
