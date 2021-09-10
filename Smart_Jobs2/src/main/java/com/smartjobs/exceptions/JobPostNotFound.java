package com.smartjobs.exceptions;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * 
 */
public class JobPostNotFound extends Exception {
 
	private String message;

	public JobPostNotFound(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
	
}
