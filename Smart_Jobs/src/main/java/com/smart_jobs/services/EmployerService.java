package com.smart_jobs.services;

import java.util.List;

import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.web.model.Employer;
import com.smart_jobs.web.model.Login;

public interface EmployerService {
	
	Employer findEmployerByName(String email);
	void add(Employer employer) throws EmployerAlreadyExists;
	void edit(Employer employer) throws EmployerNotFound;
	String delete(String empId,String empPwd) throws EmployerNotFound;
}
