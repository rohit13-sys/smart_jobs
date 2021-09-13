package com.smart_jobs.service.JobSeekerEductionalService;

import java.security.Principal;

import com.smart_jobs.web.dto.JobSeekerEducationalDetailRequest;
import com.smart_jobs.web.dto.JobSeekerEducationalDetailsResponse;

public interface JobSeekerEducationalDetailsService {
	
	public void saveEducationalDetails(JobSeekerEducationalDetailRequest educationalDetails, 
			Principal principal);
	public JobSeekerEducationalDetailsResponse getEducationalDetails(Principal principal);
	public void updateEducationalDetails(JobSeekerEducationalDetailRequest educationalDetailsRequest, 
			Principal principal);
	public void deleteEducationalDetails(Long education_id,Principal principal);
}
