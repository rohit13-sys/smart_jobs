package com.smart_jobs.services.JobSeekerEductionalService;

import java.security.Principal;

import com.smart_jobs.web.model.JobSeekerEducationDetails;

public interface JobSeekerEducationalDetailsService {

	public void saveEducationalDetails(JobSeekerEducationDetails jsEducation);

	//public JobSeekerEducationDetails getEducationalDetails(Principal principal);

	public void updateEducationalDetails(JobSeekerEducationDetails jsEducation);

	//public void deleteEducationalDetails(Long education_id, Principal principal);
}
