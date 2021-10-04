package com.smart_jobs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerEducationalDetailsRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobSeekerEducationDetails;

/*
 * @author bhargav.parmar@stltech.in
 * @version 2.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
public class jobSeekerEducationalDetailsImpl implements JobSeekerEducationalDetailsService {

	@Autowired
	private JobSeekerEducationalDetailsRepo educationalDetailsReo;

	@SuppressWarnings("unused")
	@Autowired
	private LoginRepo loginRepo;

	@Override
	public void saveEducationalDetails(JobSeekerEducationDetails jsEducation) {

//		String email = principal.getName();
//		System.out.println(email);

		// Needs to change to login table
//		JobSeekerPersonal jsPersonal = jobSeekerRepo.findByEmail(email);

//		Login login = loginRepo.findByUserIdAndPwd(jsEducation.getLogin().getUserId(),
//				jsEducation.getLogin().getPwd());
		
		// Here we have add ID of login interms of finding login 
		// This is due to no use of spring security
		//Optional<Login> login = loginRepo.findById((long) 1);

		
		educationalDetailsReo.save(jsEducation);
	}

	@Override
	public JobSeekerEducationDetails getEducationalDetails(String email) {
		
//		String email = principal.getName();
//		System.out.println(email);

//		Login login = loginRepo.findByEmail(email);
		JobSeekerEducationDetails educationalDetailsResponse 
			= new JobSeekerEducationDetails();
		
		JobSeekerEducationDetails educationalDetails 
				= educationalDetailsReo.findByLogin_UserId(email);
		
//		JobSeekerEducationDetails educationalDetails = educationalDetailsReo.findByLogin(login);

		return educationalDetails;
	}

	@Override
	public void updateEducationalDetails(JobSeekerEducationDetails jsEducation) {
		saveEducationalDetails(jsEducation);
	}

	/*
	 * Below method needs check and changes
	 */
	@Override
	public void deleteEducationalDetails(Long education_id) {
//		String email = principal.getName();
//		System.out.println(email);

//		Login login = loginRepo.findByEmail(email);

//		JobSeekerEducationDetails educationalDetails = educationalDetailsReo.findByLogin(login);
		educationalDetailsReo.deleteById(education_id);
	}
} // end of class
