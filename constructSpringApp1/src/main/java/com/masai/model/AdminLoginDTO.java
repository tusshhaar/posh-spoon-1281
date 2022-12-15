package com.masai.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginDTO {

	@NotNull(message = "username should be mandatory")
	@NotEmpty(message = "username should be mandatory")
	private String adminUsername;
	
	@NotNull(message = "password should be mandatory")
	@NotEmpty(message = "password should be mandatory")
	private String adminPassword;
	
	
}
