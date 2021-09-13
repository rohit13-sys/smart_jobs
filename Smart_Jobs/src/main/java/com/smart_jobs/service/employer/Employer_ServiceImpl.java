package com.smart_jobs.service.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.Employer_Repo;
import com.smart_jobs.web.model.Employer;

@Service
public class Employer_ServiceImpl implements Employer_Service {

	@Autowired
	Employer_Repo empRepo;

	@Override
	public Employer saveEmp(Employer emp) {
		return this.empRepo.save(emp);
	}

}
