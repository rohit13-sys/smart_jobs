package com.smart_jobs.service.jobseeker;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeeker_Repo;
import com.smart_jobs.web.model.JobSeeker;

@Service
@Transactional
public class JobSeeker_ServiceImpl implements JobSeeker_Service {

	@Autowired
	JobSeeker_Repo jsRepo;

	
	//PasswordEncoder passwordEncoder;

//	public JobSeeker_ServiceImpl() {
//		this.passwordEncoder = new BCryptPasswordEncoder();
//	}

	@Override
	public JobSeeker saveJS(JobSeeker js) {
		return jsRepo.save(js);
	}

}
