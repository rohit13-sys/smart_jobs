package com.smart_jobs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.repository.CompanyRepo;
import com.smart_jobs.repository.EmployerRepository;
import com.smart_jobs.web.model.Employer;
import com.smart_jobs.web.model.Login;

@Service
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	private EmployerRepository employerRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Override
	public void add(Employer employer) throws EmployerAlreadyExists {
		// TODO Auto-generated method stub
		Employer empList = findEmployerByName(employer.getLogin().getUserId());
		if(empList == null) {
			System.out.println("Yeah you can add" + employer.getLogin().getUserId());
			companyRepo.save(employer.getCompany());
			employerRepo.save(employer);
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
			System.out.println(employer.toString());
			employerRepo.save(employer);
		}
	}

	@Override
	public String delete(String empId,String empPwd) throws EmployerNotFound {
		// TODO Auto-generated method stub
		Employer employer = findEmployerByName(empId);
		if(employer == null)
			throw new EmployerNotFound("Sorry!! Employer is not Found...");
		else {
			if(employer.getLogin().getPwd().equals(empPwd)) {
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

	public Employer findEmployerByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("login:" + name);
		return employerRepo.findByLogin_UserId(name);
	}



}
