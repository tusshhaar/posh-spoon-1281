package com.masai.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlantException extends RuntimeException{
	public PlantException(String message) {
		super(message);
	}
}
