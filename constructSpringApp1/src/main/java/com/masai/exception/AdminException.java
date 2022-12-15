package com.masai.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdminException extends RuntimeException{
	public AdminException(String message) {
		super(message);
	}
}

