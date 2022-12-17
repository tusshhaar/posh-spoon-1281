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

    private Integer plantHeight;

    private String plantSpread;

    private String commonName;

    private String bloomTime;

    private String medicinalOrCulinaryUse;

    private String difficultyLevel;

    private String temperature;

    private String typeOfPlant;

    private String plantDescription;

    private Integer plantsStock;

    private Double plantCost;


}
