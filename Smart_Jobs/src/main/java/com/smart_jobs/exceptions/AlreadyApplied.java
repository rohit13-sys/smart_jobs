package com.smart_jobs.exceptions;

public class AlreadyApplied extends Exception {

	private String message;
	
	
	public AlreadyApplied(String message) {
		super(message);
		this.message = message;
	}
}
