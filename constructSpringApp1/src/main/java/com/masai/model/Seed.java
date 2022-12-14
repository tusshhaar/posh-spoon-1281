package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seed {
	@Id
	private Integer SeedId;
	private String CommanName;
	private String BloomTime;
	private String Watering;
	private String DifficultLevel;
	private String Temperature;
	private String TypeOfSeeds;
	private String SeedDescription;
	private Integer StockOfSeed;
	private Double SeedCost;
	private Integer SeedPerPacked;
	
	@Override
	public String toString() {
		return "Seed [SeedId=" + SeedId + ", CommanName=" + CommanName + ", BloomTime=" + BloomTime + ", Watering="
				+ Watering + ", DifficultLevel=" + DifficultLevel + ", Temperature=" + Temperature + ", TypeOfSeeds="
				+ TypeOfSeeds + ", SeedDescription=" + SeedDescription + ", StockOfSeed=" + StockOfSeed + ", SeedCost="
				+ SeedCost + ", SeedPerPacked=" + SeedPerPacked + "]";
	}

	public Integer getSeedId() {
		return SeedId;
	}

	public void setSeedId(Integer seedId) {
		SeedId = seedId;
	}

	public String getCommanName() {
		return CommanName;
	}

	public void setCommanName(String commanName) {
		CommanName = commanName;
	}

	public String getBloomTime() {
		return BloomTime;
	}

	public void setBloomTime(String bloomTime) {
		BloomTime = bloomTime;
	}

	public String getWatering() {
		return Watering;
	}

	public void setWatering(String watering) {
		Watering = watering;
	}

	public String getDifficultLevel() {
		return DifficultLevel;
	}

	public void setDifficultLevel(String difficultLevel) {
		DifficultLevel = difficultLevel;
	}

	public String getTemperature() {
		return Temperature;
	}

	public void setTemperature(String temperature) {
		Temperature = temperature;
	}

	public String getTypeOfSeeds() {
		return TypeOfSeeds;
	}

	public void setTypeOfSeeds(String typeOfSeeds) {
		TypeOfSeeds = typeOfSeeds;
	}

	public String getSeedDescription() {
		return SeedDescription;
	}

	public void setSeedDescription(String seedDescription) {
		SeedDescription = seedDescription;
	}

	public Integer getStockOfSeed() {
		return StockOfSeed;
	}

	public void setStockOfSeed(Integer stockOfSeed) {
		StockOfSeed = stockOfSeed;
	}

	public Double getSeedCost() {
		return SeedCost;
	}

	public void setSeedCost(Double seedCost) {
		SeedCost = seedCost;
	}

	public Integer getSeedPerPacked() {
		return SeedPerPacked;
	}

	public void setSeedPerPacked(Integer seedPerPacked) {
		SeedPerPacked = seedPerPacked;
	}

	public Seed(String commanName, String bloomTime, String watering, String difficultLevel, String temperature,
			String typeOfSeeds, String seedDescription, Integer stockOfSeed, Double seedCost, Integer seedPerPacked) {
		super();
		CommanName = commanName;
		BloomTime = bloomTime;
		Watering = watering;
		DifficultLevel = difficultLevel;
		Temperature = temperature;
		TypeOfSeeds = typeOfSeeds;
		SeedDescription = seedDescription;
		StockOfSeed = stockOfSeed;
		SeedCost = seedCost;
		SeedPerPacked = seedPerPacked;
	}

	public Seed(Integer seedId, String commanName, String bloomTime, String watering, String difficultLevel,
			String temperature, String typeOfSeeds, String seedDescription, Integer stockOfSeed, Double seedCost,
			Integer seedPerPacked) {
		super();
		SeedId = seedId;
		CommanName = commanName;
		BloomTime = bloomTime;
		Watering = watering;
		DifficultLevel = difficultLevel;
		Temperature = temperature;
		TypeOfSeeds = typeOfSeeds;
		SeedDescription = seedDescription;
		StockOfSeed = stockOfSeed;
		SeedCost = seedCost;
		SeedPerPacked = seedPerPacked;
	}
	
	
	
}
