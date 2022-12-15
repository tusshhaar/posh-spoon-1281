package com.masai.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerLoginDTO {

	@NotNull(message = "username is mandatory")
	@NotEmpty(message = "Please enter username")
	private String customerUsername;
	
	@NotEmpty(message = "Please enter password")
	private String customerPassword;
	
}
