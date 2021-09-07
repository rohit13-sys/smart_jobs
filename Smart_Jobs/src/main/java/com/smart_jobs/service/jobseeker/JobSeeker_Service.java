package com.smart_jobs.service.jobseeker;

import org.springframework.stereotype.Service;

import com.smart_jobs.web.model.JobSeeker;
import com.smart_jobs.web.model.Login;

@Service
public interface JobSeeker_Service {

	//Login loginCheck(String email, String password);
	
	JobSeeker saveJS(JobSeeker js);
}
