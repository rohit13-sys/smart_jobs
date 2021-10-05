package com.smart_jobs.exceptions;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * 
 * */

public class EmployerNotFound extends Exception {
	
	private String message;

	public EmployerNotFound(String message) {
		super(message);
		this.message = message;
	}
	
	
}
