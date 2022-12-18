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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer plantId;

    @NotNull(message = "Plant height can not be null")
    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
    private Integer plantHeight;
    
    @NotBlank(message = "Plant Spread can not be blank")
    private String plantSpread;
    
    @NotBlank(message = "Plant name can not be blank")
    private String commonName;
    
    @NotBlank(message = "BloomTime can not be blank")
    private String bloomTime;
    
    @NotBlank(message = "Provide is it medicinal or Culinary Use ")
    private String medicinalOrCulinaryUse;

    private String difficultyLevel;

    private String temperature;
    
    @NotBlank(message = "TypeOfPlant can not be blank")
    private String typeOfPlant;
    
    @NotNull(message = "Plant Description can not be null")
    private String plantDescription;
    
    @NotNull(message = "Plant Stock can not be null")
    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
    private Integer plantsStock;
    
    @NotNull(message = "plant cost can not be null")
    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
    private Double plantCost;

}
