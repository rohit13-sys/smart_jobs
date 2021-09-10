package com.smart_jobs.exceptions;

public class EmployerNotFound extends Exception {
	
	private String message;

	public EmployerNotFound(String message) {
		super(message);
		this.message = message;
	}
	
	
}
