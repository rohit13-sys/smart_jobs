package com.smart_jobs.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerExperienceDetailsRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobSeekerExperienceDetails;

/*
 * @author bhargav.parmar@stltech.in
 * @version 2.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
public class JobSeekerExperienceDetailsImpl implements JobSeekerExperienceDetailsService {
	
	private static final Logger LOGGER = LogManager.getLogger(JobSeekerExperienceDetailsImpl.class);

	@Autowired
	private JobSeekerExperienceDetailsRepo experienceDetailsRepo;

	@SuppressWarnings("unused")
	@Autowired
	private LoginRepo loginRepo;

	@Override
	public void saveExperienceDetails(JobSeekerExperienceDetails jsExperience) {
		experienceDetailsRepo.save(jsExperience);
		LOGGER.debug("Experience details saved.");
	}

	@Override
	public JobSeekerExperienceDetails getExperienceDetails(String email) {
		JobSeekerExperienceDetails experienceDetails = experienceDetailsRepo.findByJsPersonalId_Login_UserId(email);
		return experienceDetails;
	}

	@Override
	public void updateExperienceDetails(JobSeekerExperienceDetails jsExperience) {
		saveExperienceDetails(jsExperience);
	}

	@Override
	public void deleteExperienceDetails(Long exp_id) {
		experienceDetailsRepo.deleteById(exp_id);
		LOGGER.debug("Experience details deleted.");
	}
}
