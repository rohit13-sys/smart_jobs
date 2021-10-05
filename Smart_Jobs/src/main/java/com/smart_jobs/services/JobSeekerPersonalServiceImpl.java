package com.smart_jobs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobActivityRepository;
import com.smart_jobs.repository.JobSeekerEducationalDetailsRepo;
import com.smart_jobs.repository.JobSeekerExperienceDetailsRepo;
import com.smart_jobs.repository.JobSeekerPersonalRepo;
import com.smart_jobs.repository.JsSkillsRepository;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobActivityStatus;
import com.smart_jobs.web.model.JobSeekerEducationDetails;
import com.smart_jobs.web.model.JobSeekerExperienceDetails;
import com.smart_jobs.web.model.JobSeekerPersonal;
import com.smart_jobs.web.model.JsSkills;
import com.smart_jobs.web.model.Login;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
@Transactional
public class JobSeekerPersonalServiceImpl implements JobSeekerPersonalService {
	
	private static final Logger LOGGER = LogManager.getLogger(JobSeekerPersonalServiceImpl.class);

	@Autowired
	private JobSeekerPersonalRepo jobSeekerRepo;

	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private JsSkillsRepository jsSkillsRepo;
	
	@Autowired
	private JobActivityRepository jsActRepo;

	@Autowired
	private JobSeekerEducationalDetailsRepo jsEdRepo;
	
	@Autowired
	private JobSeekerExperienceDetailsRepo jsExRepo;
	
	@Override
	public void saveJobSeeker(JobSeekerPersonal jsPersonal) {
		Set<JsSkills> jsSkills = jsPersonal.getSkills();
//		System.out.println(jsPersonal);
		LOGGER.debug(jsPersonal);
//		Login login = loginRepo.saveAndFlush(jsPersonal.getLogin());
		jsPersonal = jobSeekerRepo.save(jsPersonal);
		JobSeekerEducationDetails jsEd = jsPersonal.getJsEduId();
		jsEd.setJsPersonalId(jsPersonal);
		JobSeekerExperienceDetails jsEx = jsPersonal.getJsExpId();
		jsEx.setJsPersonalId(jsPersonal);
		jsEdRepo.save(jsEd);
		jsExRepo.save(jsEx);
		for(JsSkills skills: jsSkills) {
			skills.setSr_no(jsPersonal);
			jsSkillsRepo.save(skills);
		}
		LOGGER.debug("Job Seeker Personal details saved.");
		
	}

	@Override
	public JobSeekerPersonal getJobSeeker(String email) {
//		Login login=new Login();
		//email="xyz@gmail.com";
		JobSeekerPersonal personalDetails = jobSeekerRepo.findByLogin_UserId(email);
//		System.out.println("Persona;Details>>>>"+personalDetails);
//		JobSeekerPersonal personalResponse = new JobSeekerPersonal();
		LOGGER.debug(personalDetails);
		return personalDetails;
	}

	@Override
	public void updateJobSeeker(JobSeekerPersonal jsPersonal) {
		saveJobSeeker(jsPersonal);
	}
	
	@Override
	public void deleteJobSeeker(Long sr_no) {
		System.out.println(sr_no);
		JobSeekerPersonal jsPersonal = jobSeekerRepo.findById(sr_no).get();
		for(JsSkills skills:jsPersonal.getSkills()) {
			jsSkillsRepo.delete(skills);
		}
		jobSeekerRepo.deleteById(sr_no);
		loginRepo.delete(jsPersonal.getLogin());
		LOGGER.debug("Job sekker personal details is deleted.");
	}
	
	@Override
	public List<JobSeekerPersonal> findJsByJpId(Long JbId) {
		List<JobActivityStatus> jobas = jsActRepo.findByJobPost_JobPostId(JbId);
		System.out.println(jobas);
		List<JobSeekerPersonal> apJobSeekers = new ArrayList<>(); 
		for(JobActivityStatus job: jobas) {
			apJobSeekers.add(job.getJspersonal());
		}
		LOGGER.debug(apJobSeekers);
		return apJobSeekers;
	}
	
}
