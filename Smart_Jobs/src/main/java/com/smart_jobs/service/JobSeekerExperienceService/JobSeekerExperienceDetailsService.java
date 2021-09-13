package com.smart_jobs.service.JobSeekerExperienceService;

import java.security.Principal;

import com.smart_jobs.web.dto.JobSeekerExperienceDetailsResponse;
import com.smart_jobs.web.dto.JobSeekerExperienceDetailsRequest;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public interface JobSeekerExperienceDetailsService {
	
	
	public void saveExperienceDetails(JobSeekerExperienceDetailsRequest experienceDetails
			, Principal principal);
	public void updateExperienceDetails(JobSeekerExperienceDetailsRequest experienceDetailsRequest, 
			Principal principal);
	public void deleteExperienceDetails(Long exp_id, Principal principal);
	public JobSeekerExperienceDetailsResponse getExperienceDetails(Principal principal);

}
