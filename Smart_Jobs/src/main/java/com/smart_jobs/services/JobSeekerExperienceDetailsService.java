package com.smart_jobs.services;

import java.security.Principal;

import com.smart_jobs.web.model.JobSeekerExperienceDetails;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public interface JobSeekerExperienceDetailsService {
	
	
	public void saveExperienceDetails(JobSeekerExperienceDetails experienceDetails);
	public void updateExperienceDetails(JobSeekerExperienceDetails experienceDetailsRequest);
	public void deleteExperienceDetails(Long exp_id);
	public JobSeekerExperienceDetails getExperienceDetails(String email);

}
