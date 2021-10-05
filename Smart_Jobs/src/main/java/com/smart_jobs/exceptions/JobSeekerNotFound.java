package com.smart_jobs.exceptions;

public class JobSeekerNotFound extends Exception {
	
	private String message;

	public JobSeekerNotFound(String message) {
		super(message);
		this.message = message;
	}
	
	
	
}
