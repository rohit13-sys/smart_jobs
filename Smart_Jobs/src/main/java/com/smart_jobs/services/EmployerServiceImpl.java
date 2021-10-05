package com.smart_jobs.services;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.repository.CompanyRepo;
import com.smart_jobs.repository.EmployerRepository;
import com.smart_jobs.repository.JobPostRepository;
import com.smart_jobs.web.model.Employer;
import com.smart_jobs.web.model.JobPost;
import com.smart_jobs.web.model.Login;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * @description Service implementation of Employer
 * */

@Service
public class EmployerServiceImpl implements EmployerService {

	private static final Logger LOGGER=LogManager.getLogger();
	
	@Autowired
	private EmployerRepository employerRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private JobPostRepository jobPostRepo;
	
	@Autowired
	private JobPostService jpService;
	
	@Override
	public void add(Employer employer) throws EmployerAlreadyExists {
		// TODO Auto-generated method stub
		
		Employer empList;
		empList = findEmployerByName(employer.getLogin().getUserId());
		if(empList == null) {
			System.out.println("Yeah you can add" + employer.getLogin().getUserId());
			companyRepo.save(employer.getCompany());
			employerRepo.save(employer);
			LOGGER.info("Employer Saved!!!");
		}
		else 
			throw new EmployerAlreadyExists("Sorry!! Employer is Already Exists...");
	}

	@Override
	public void edit(Employer employer) throws EmployerNotFound {
		// TODO Auto-generated method stub
		Employer empList = findEmployerByName(employer.getLogin().getUserId());
		if(empList == null)
			throw new EmployerNotFound("Sorry!! Employer is not Found...");
		else {
			employer.setEmployerNo(empList.getEmployerNo());
			 
			System.out.println(employer);
			employerRepo.save(employer);
		}
	}

	@Override
	public String delete(String empId,String empPwd) throws EmployerNotFound, JobPostNotFound {
		// TODO Auto-generated method stub
		Employer employer = findEmployerByName(empId);
		if(employer == null)
			throw new EmployerNotFound("Sorry!! Employer is not Found...");
		else {
			if(employer.getLogin().getPwd().equals(empPwd)) {
				List<JobPost> jp = jobPostRepo.findByEmployee_login_userId(empId);
				if(jp!=null) {
					for(JobPost j:jp) {
						jpService.deleteJob(j.getJobPostId());
					}
				}
				employerRepo.delete(employer);
				if(employerRepo.countByCompany_CompanyName(employer.getCompany().getCompanyName())<=0) {
					companyRepo.delete(employer.getCompany());
				}
				return "Employee Deleted Successfully";
			}
			else
				return "Please Enter Password Correctly";
		}
	}

	@Override
	public Employer findEmployerByName(String email){
		// TODO Auto-generated method stub
		return employerRepo.findByLogin_UserId(email).orElse(null);
	}

	



}
