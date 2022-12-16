package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seed {
	
	@Id
	private Integer seedId;
	private String commanName;
	private String bloomTime;
	private String watering;
	private String difficultLevel;
	private String temparature;
	private String TypeOfSeed;
	private String SeedDescription;
	private Integer SeedStock;
	private Double SeedsCost;
	private Integer SeedPerPacked;
	
}
