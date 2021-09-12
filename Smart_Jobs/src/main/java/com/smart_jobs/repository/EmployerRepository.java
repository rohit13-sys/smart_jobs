package com.smart_jobs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.Employer;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * 
 * */

public interface EmployerRepository extends JpaRepository<Employer,Long>{
	//@Query("select e from Employer e where e.login = ?1")
	Optional<Employer> findByLogin_UserId(String email);
	
	int countByCompany_CompanyName(String name);
}
