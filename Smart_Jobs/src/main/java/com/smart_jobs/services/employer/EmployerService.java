package com.smart_jobs.services.employer;


import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.web.model.Employer;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * @description Employer Service Interface
 * */

public interface EmployerService {
	
	Employer findEmployerByName(String email);
	void add(Employer employer) throws EmployerAlreadyExists;
	void edit(Employer employer) throws EmployerNotFound;
	String delete(String empId,String empPwd) throws EmployerNotFound;
}
