package com.smart_jobs.services;

import com.smart_jobs.web.model.JobSeekerEducationDetails;

/*
 * @author bhargav.parmar@stltech.in
 * @version 2.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public interface JobSeekerEducationalDetailsService {

	public void saveEducationalDetails(JobSeekerEducationDetails jsEducation);

	public JobSeekerEducationDetails getEducationalDetails();

	public void updateEducationalDetails(JobSeekerEducationDetails jsEducation);

	public void deleteEducationalDetails(Long education_id);
}
