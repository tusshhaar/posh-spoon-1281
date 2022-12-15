package Exceptions;

import java.time.LocalDateTime;



public class customError extends RuntimeException {
	
	private LocalDateTime timeStamp;
	private String message;
	private String details;
}
