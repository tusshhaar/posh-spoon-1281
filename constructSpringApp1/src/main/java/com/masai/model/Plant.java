package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
	private Integer plantId;
	private Integer plantHeight;
	private String plantSpread;
	private String commonName;
	private String bloomTime;
	private String medicinal;
	private String difficultyLevel;
	private String temperature;
	private String typeOfPlant;
	private String plantDescription;
	private Integer plantsStock;
	private Double plantCost;
}