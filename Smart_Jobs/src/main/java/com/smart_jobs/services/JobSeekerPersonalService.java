package com.smart_jobs.services;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smart_jobs.exceptions.JobActivityStatusNotFound;
import com.smart_jobs.exceptions.JobSeekerNotFound;
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

	public void deleteJobSeeker(Long sr_no) throws JobActivityStatusNotFound,JobSeekerNotFound;

	public JobSeekerPersonal getJobSeeker(String email);

	List<JobSeekerPersonal> findJsByJpId(Long JbId);
	
	public void saveImage(MultipartFile file,String id);
}
