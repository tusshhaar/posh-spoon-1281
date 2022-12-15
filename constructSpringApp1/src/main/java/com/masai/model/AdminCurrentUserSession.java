package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminCurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer adminId;
	
	private String adminUuid;
	
	private LocalDateTime localDateTime;
	
	
}
