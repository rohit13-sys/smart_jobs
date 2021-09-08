package com.smart_jobs.service.jobseeker;

import org.springframework.stereotype.Service;

import com.smart_jobs.web.model.JobSeeker_Personal;
import com.smart_jobs.web.model.Login;

@Service
public interface JobSeeker_Service {

	//Login loginCheck(String email, String password);
	
	JobSeeker_Personal saveJS(JobSeeker_Personal js);
}
