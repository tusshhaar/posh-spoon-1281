package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
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
	public Seed(Integer seedId, String commanName, String bloomTime, String watering, String difficultLevel,
			String temparature, String typeOfSeed, String seedDescription, Integer seedStock, Double seedsCost,
			Integer seedPerPacked) {
		super();
		this.seedId = seedId;
		this.commanName = commanName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultLevel = difficultLevel;
		this.temparature = temparature;
		TypeOfSeed = typeOfSeed;
		SeedDescription = seedDescription;
		SeedStock = seedStock;
		SeedsCost = seedsCost;
		SeedPerPacked = seedPerPacked;
	}
	public Seed(String commanName, String bloomTime, String watering, String difficultLevel, String temparature,
			String typeOfSeed, String seedDescription, Integer seedStock, Double seedsCost, Integer seedPerPacked) {
		super();
		this.commanName = commanName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultLevel = difficultLevel;
		this.temparature = temparature;
		TypeOfSeed = typeOfSeed;
		SeedDescription = seedDescription;
		SeedStock = seedStock;
		SeedsCost = seedsCost;
		SeedPerPacked = seedPerPacked;
	}
	public Seed() {
		super();
	}
	public Integer getSeedId() {
		return seedId;
	}
	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}
	public String getCommanName() {
		return commanName;
	}
	public void setCommanName(String commanName) {
		this.commanName = commanName;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getDifficultLevel() {
		return difficultLevel;
	}
	public void setDifficultLevel(String difficultLevel) {
		this.difficultLevel = difficultLevel;
	}
	public String getTemparature() {
		return temparature;
	}
	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}
	public String getTypeOfSeed() {
		return TypeOfSeed;
	}
	public void setTypeOfSeed(String typeOfSeed) {
		TypeOfSeed = typeOfSeed;
	}
	public String getSeedDescription() {
		return SeedDescription;
	}
	public void setSeedDescription(String seedDescription) {
		SeedDescription = seedDescription;
	}
	public Integer getSeedStock() {
		return SeedStock;
	}
	public void setSeedStock(Integer seedStock) {
		SeedStock = seedStock;
	}
	public Double getSeedsCost() {
		return SeedsCost;
	}
	public void setSeedsCost(Double seedsCost) {
		SeedsCost = seedsCost;
	}
	public Integer getSeedPerPacked() {
		return SeedPerPacked;
	}
	public void setSeedPerPacked(Integer seedPerPacked) {
		SeedPerPacked = seedPerPacked;
	}
	@Override
	public String toString() {
		return "Seed [seedId=" + seedId + ", commanName=" + commanName + ", bloomTime=" + bloomTime + ", watering="
				+ watering + ", difficultLevel=" + difficultLevel + ", temparature=" + temparature + ", TypeOfSeed="
				+ TypeOfSeed + ", SeedDescription=" + SeedDescription + ", SeedStock=" + SeedStock + ", SeedsCost="
				+ SeedsCost + ", SeedPerPacked=" + SeedPerPacked + "]";
	}

}
