package com.masai.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private Integer bookingOrderId;
	
	private String sessionKey;
	
	@NotNull(message =  "Local DateTime is mandatory")
	private LocalDateTime localDateTime;
	
	private String transactionMode;
	
	@NotNull(message =  "quantity is mandatory")
	@Min(value = 1,message = "Minimum quantity of Product must be greater than 0")
	private Integer quantity;
	
	@NotNull(message =  "Total Cost is mandatory")
	private Double totalCost;
	
	private String productType;
	
	
}
