package com.smart_jobs.services;

import java.security.Principal;

import org.springframework.stereotype.Service;

import com.smart_jobs.web.model.JobSeekerPersonal;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
public interface JobSeekerPersonalService {

	// Login loginCheck(String email, String password);

	public void saveJobSeeker(JobSeekerPersonal jsPersonal);

	public void updateJobSeeker(JobSeekerPersonal jsPersonal);

	public void deleteJobSeeker(Long sr_no);

	public JobSeekerPersonal getJobSeeker();
}
