package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer,Long>{
	//@Query("select e from Employer e where e.login = ?1")
	Employer findByLogin_UserId(String email);
	
	int countByCompany_CompanyName(String name);
}
