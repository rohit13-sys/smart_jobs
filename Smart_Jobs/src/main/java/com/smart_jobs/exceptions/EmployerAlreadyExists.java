package com.smart_jobs.exceptions;

public class EmployerAlreadyExists extends Exception {
	
	private String message;

	public EmployerAlreadyExists(String message) {
		super(message);
		this.message = message;
	}
	
}
