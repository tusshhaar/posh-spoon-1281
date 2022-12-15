package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seed {
	private Integer seedId;
	private String commonName;
	private String bloomTime;
	private String watering;
	private String difficultyLevel;
	private String temperature;
	private String typeOfSeeds;
	private String seedsDescription;
	private Integer seedsStock;
	private Double seedsost;
	private Integer seedsPerPacket;
}
