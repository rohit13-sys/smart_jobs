package com.smart_jobs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerEducationalDetailsRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobSeekerEducationDetails;
import com.smart_jobs.web.model.Login;

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
		JobSeekerEducationDetails jsEduDetails = 
				new JobSeekerEducationDetails();
		
		// Here we have add ID of login interms of finding login 
		// This is due to no use of spring security
		//Optional<Login> login = loginRepo.findById((long) 1);

		jsEduDetails.setHSC_result(jsEducation.getHSC_result());
		jsEduDetails.setSSC_result(jsEducation.getSSC_result());
		jsEduDetails.setUniversity_name(jsEducation.getUniversity_name());
		jsEduDetails.setStart_date(jsEducation.getStart_date());
		jsEduDetails.setEnd_date(jsEducation.getEnd_date());
		jsEduDetails.setPercentage(jsEducation.getPercentage());
		jsEduDetails.setCgpa(jsEducation.getCgpa());
		//jsEduDetails.setLogin(login.get());
		educationalDetailsReo.save(jsEducation);
	}

	@Override
	public JobSeekerEducationDetails getEducationalDetails() {
		
//		String email = principal.getName();
//		System.out.println(email);

//		Login login = loginRepo.findByEmail(email);
		JobSeekerEducationDetails educationalDetailsResponse 
			= new JobSeekerEducationDetails();
		
		Optional<JobSeekerEducationDetails> educationalDetails 
				= educationalDetailsReo.findById((long) 3001);

//		JobSeekerEducationDetails educationalDetails = educationalDetailsReo.findByLogin(login);

		educationalDetailsResponse.setHSC_result(educationalDetails.get().getHSC_result());
		educationalDetailsResponse.setSSC_result(educationalDetails.get().getSSC_result());
		educationalDetailsResponse.setUniversity_name(educationalDetails.get().getUniversity_name());
		educationalDetailsResponse.setStart_date(educationalDetails.get().getStart_date());
		educationalDetailsResponse.setEnd_date(educationalDetails.get().getEnd_date());
		educationalDetailsResponse.setCgpa(educationalDetails.get().getCgpa());
		educationalDetailsResponse.setHSC_result(educationalDetails.get().getHSC_result());
		return educationalDetailsResponse;
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
