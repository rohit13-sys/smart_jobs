package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobSeekerPersonal;
import com.smart_jobs.web.model.Login;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public interface JobSeekerPersonalRepo extends JpaRepository<JobSeekerPersonal,Long> {
	public JobSeekerPersonal findByLogin(Login login);
}
