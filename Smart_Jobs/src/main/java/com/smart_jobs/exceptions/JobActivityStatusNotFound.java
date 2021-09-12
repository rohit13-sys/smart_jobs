package com.smart_jobs.exceptions;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * 
 */
public class JobActivityStatusNotFound extends Exception {

	private String message;

	public JobActivityStatusNotFound(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
	
	
	
}
