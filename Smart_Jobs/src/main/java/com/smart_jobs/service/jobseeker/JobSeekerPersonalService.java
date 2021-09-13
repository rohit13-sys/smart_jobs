package com.smart_jobs.service.jobseeker;

import java.security.Principal;

import org.springframework.stereotype.Service;

import com.smart_jobs.web.dto.JobSeekerPersonalRequest;
import com.smart_jobs.web.dto.JobSeekerPersonalResponse;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
public interface JobSeekerPersonalService {

	//Login loginCheck(String email, String password);
	
	public void saveJobSeeker(JobSeekerPersonalRequest jobSeekerRegisterRequest, 
			Principal principal);
	public void updateJobSeeker(JobSeekerPersonalRequest jobSeekerRegisterRequest, Principal principal);
	public void deleteJobSeeker(Long sr_no,Principal principal);
	public JobSeekerPersonalResponse getJobSeeker(Principal principal);
}
