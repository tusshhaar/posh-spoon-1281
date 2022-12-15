package com.masai.exception;

public class PlantNotFoundException extends RuntimeException {

	public PlantNotFoundException() {

	}

	public PlantNotFoundException(String message) {

		super(message);
	}

}
