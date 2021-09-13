package com.smart_jobs.service.jobseeker;

import java.security.Principal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerPersonalRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.dto.JobSeekerPersonalRequest;
import com.smart_jobs.web.dto.JobSeekerPersonalResponse;
import com.smart_jobs.web.model.JobSeekerPersonal;
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

	@Autowired
	private JobSeekerPersonalRepo jobSeekerRepo;
	
	@Autowired
	private LoginRepo loginRepo;

	@Override
	public void saveJobSeeker(JobSeekerPersonalRequest jobSeekerRegisterRequest, 
			Principal principal) {
		
		// Get current user/jobseeker
		String email = principal.getName();
		System.out.println(email); // debug
		
		// updated
		Login login = loginRepo.findByEmail(email);
		
		JobSeekerPersonal jobSeeker = new JobSeekerPersonal();
		jobSeeker.setSeeker_name(jobSeekerRegisterRequest.getJobSeekerName());
		jobSeeker.setPh_no(jobSeekerRegisterRequest.getPh_no());
		jobSeeker.setPhoto(jobSeekerRegisterRequest.getPhoto());
		jobSeeker.setResume(jobSeekerRegisterRequest.getResume());
		jobSeeker.setLogin(login);
		jobSeekerRepo.save(jobSeeker);
	}

	@Override
	public JobSeekerPersonalResponse getJobSeeker(Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		
		// updated
		Login login = loginRepo.findByEmail(email);
		
		// Getting Details using foreign key "Login"
		JobSeekerPersonal personalDetails = jobSeekerRepo.findByLogin(login);
		
		JobSeekerPersonalResponse personalResponse = 
				new JobSeekerPersonalResponse();
		personalResponse.setSeeker_name(personalDetails.getSeeker_name());
		personalResponse.setPh_no(personalDetails.getPh_no());
		personalResponse.setPhoto(personalDetails.getPhoto());
		personalResponse.setResume(personalDetails.getResume());
		return personalResponse;
	}
	
	@Override
	public void updateJobSeeker(JobSeekerPersonalRequest jobSeekerRegisterRequest, Principal principal) {
		saveJobSeeker(jobSeekerRegisterRequest, principal);
	}

	/*
	 * Below method needs check and changes
	 */
	@Override
	public void deleteJobSeeker(Long sr_no,Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		jobSeekerRepo.deleteById(sr_no);
	}
}
