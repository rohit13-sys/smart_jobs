package com.smart_jobs.services;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerPersonalRepo;
import com.smart_jobs.repository.JsSkillsRepository;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobSeekerPersonal;
import com.smart_jobs.web.model.JsSkills;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
@Transactional
public class JobSeekerPersonalServiceImpl implements JobSeekerPersonalService {

	@Autowired
	private JobSeekerPersonalRepo jobSeekerRepo;

	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private JsSkillsRepository jsSkillsRepo;

	@Override
	public void saveJobSeeker(JobSeekerPersonal jsPersonal) {

		// Get current user/jobseeker
//		String email = principal.getName();
//		System.out.println(email); // debug
		
		// list of login 
		
//		Optional<Login> login = loginRepo.findAll();

		// updated
//		Login login = loginRepo.findByUserIdAndPwd(jsPersonal.getLogin().getUserId(),
//				jsPersonal.getLogin().getPwd());

//		JobSeekerPersonal jobSeeker = new JobSeekerPersonal();
//		jobSeeker.setSr_no((long) 8001);
//		jobSeeker.setSeeker_name(jsPersonal.getSeeker_name());
//		jobSeeker.setPh_no(jsPersonal.getPh_no());
//		jobSeeker.setPhoto(jsPersonal.getPhoto());
//		jobSeeker.setResume(jsPersonal.getResume());
//		jobSeeker.setLogin();
		Set<JsSkills> jsSkills = jsPersonal.getSkills();
		System.out.println(jsPersonal);
		jsPersonal = jobSeekerRepo.save(jsPersonal);
		
		for(JsSkills skills: jsSkills) {
			skills.setSr_no(jsPersonal);
			jsSkillsRepo.save(skills);
		}
		
	}

	@Override
	public JobSeekerPersonal getJobSeeker() {
//		String email = principal.getName();
//		System.out.println(email);

//		 updated
//		Login login = loginRepo.findByEmail(email);
//		Login login = loginRepo.findByUserIdAndPwd(jsPersonal.getLogin().getUserId(),
//				jsPersonal.getLogin().getPwd());

		// Getting Details using foreign key "Login"
		// Manually insert ID of jobseeker personal 
		Optional<JobSeekerPersonal> personalDetails = jobSeekerRepo.findById((long) 3001);

		JobSeekerPersonal personalResponse = new JobSeekerPersonal();
		personalResponse.setSeeker_name(personalDetails.get().getSeeker_name());
		personalResponse.setPh_no(personalDetails.get().getPh_no());
		personalResponse.setPhoto(personalDetails.get().getPhoto());
		personalResponse.setResume(personalDetails.get().getResume());
		return personalResponse;
	}

	@Override
	public void updateJobSeeker(JobSeekerPersonal jsPersonal) {
		saveJobSeeker(jsPersonal);
	}
	
	@Override
	public void deleteJobSeeker(Long sr_no) {
		System.out.println(sr_no);
		System.out.println(jobSeekerRepo.findById(sr_no));
		jobSeekerRepo.deleteById(sr_no);
	}
}
