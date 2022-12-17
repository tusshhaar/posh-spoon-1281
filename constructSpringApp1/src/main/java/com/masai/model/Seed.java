package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;
	@NotBlank(message = "Seed Name is Mandatory")
	private String commanName;
	@NotBlank(message = "Bloom Time is Mandatory")
	private String bloomTime;
	@NotBlank(message = "Watering is Mandatory")
	private String watering;
	@NotBlank(message = "DifficultLevel is Mandatory")
	private String difficultLevel;
	@NotBlank(message = "Temparature is Mandatory")
	private String temparature;
	@NotBlank(message = "TypeOfSeed is Mandatory")
	private String TypeOfSeed;
	@NotBlank(message = "Seed Description is Mandatory")
	private String SeedDescription;
	@NotNull(message = "stock value can not be null")
	@Min(value =  0,message = "stock value must be greater than equal to 0")
	private Integer SeedStock;
	@NotNull(message = "Seed Cost should not be null")
	@Min(value = 1 , message = "stock value must be greater than equal to 1")
	private Double SeedsCost;
	@NotNull(message = "Seed Per Packed should not be null")
	private Integer SeedPerPacked;


}
