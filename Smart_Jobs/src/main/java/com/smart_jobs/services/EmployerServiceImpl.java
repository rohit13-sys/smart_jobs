package com.smart_jobs.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.repository.CompanyRepo;
import com.smart_jobs.repository.EmployerRepository;
import com.smart_jobs.web.model.Employer;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * @description Service implementation of Employer
 * */

@Service
public class EmployerServiceImpl implements EmployerService {
	
	 private static final Logger LOGGER = LogManager.getLogger(EmployerServiceImpl.class);

	@Autowired
	private EmployerRepository employerRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Override
	public void add(Employer employer) throws EmployerAlreadyExists {
		// TODO Auto-generated method stub
		Employer empList;
		empList = findEmployerByName(employer.getLogin().getUserId());
		LOGGER.debug("Employer List: "+empList);
		if(empList == null) {
			System.out.println("Yeah you can add " + employer.getLogin().getUserId());
			companyRepo.save(employer.getCompany());
			employerRepo.save(employer);
			LOGGER.debug("Employer is Added in database.");
		}
		else {
			LOGGER.error("Employer exist");
			throw new EmployerAlreadyExists("Sorry!! Employer is Already Exists...");
		}
}

	@Override
	public void edit(Employer employer) throws EmployerNotFound {
		// TODO Auto-generated method stub
		Employer empList = findEmployerByName(employer.getLogin().getUserId());
		if(empList == null) {
			LOGGER.error("Employer is not found.");
			throw new EmployerNotFound("Sorry!! Employer is not Found...");
		}
		else {
			employer.setEmployerNo(empList.getEmployerNo());
			System.out.println(employer);
			LOGGER.debug("Employer: "+employer);
			employerRepo.save(employer);
		}
	}

	@Override
	public String delete(String empId,String empPwd) throws EmployerNotFound {
		// TODO Auto-generated method stub
		Employer employer = findEmployerByName(empId);
		if(employer == null) {
			LOGGER.error("Sorry!! Employer is not Found...");
			throw new EmployerNotFound("Sorry!! Employer is not Found...");
		}
		else {
			if(employer.getLogin().getPwd().equals(empPwd)) {
				employerRepo.delete(employer);
				if(employerRepo.countByCompany_CompanyName(employer.getCompany().getCompanyName())<=0) {
					companyRepo.delete(employer.getCompany());
				}
				LOGGER.debug("Employee Deleted");
				return "Employee Deleted Successfully";
			}
			else {
				LOGGER.debug("Wrong password.");
				return "Please Enter Password Correctly";
			}
		}
	}

	@Override
	public Employer findEmployerByName(String email){
		return employerRepo.findByLogin_UserId(email).orElse(null);
	}

	



}
