package com.smart_jobs.service.JobSeekerEductionalService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerEducationalDetailsRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.dto.JobSeekerEducationalDetailRequest;
import com.smart_jobs.web.dto.JobSeekerEducationalDetailsResponse;
import com.smart_jobs.web.model.JobSeekerEducationDetails;
import com.smart_jobs.web.model.Login;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Service
public class jobSeekerEducationalDetailsImpl implements JobSeekerEducationalDetailsService{
	
	@Autowired
	private JobSeekerEducationalDetailsRepo educationalDetailsReo;
	
	@Autowired
	private LoginRepo loginRepo;
	
	
	@Override
	public void saveEducationalDetails(JobSeekerEducationalDetailRequest educationalDetails, 
			Principal principal) {
		JobSeekerEducationDetails jsEducationalDetails = 
				new JobSeekerEducationDetails();
		
		String email = principal.getName();
		System.out.println(email);
		
		// Needs to change to login table 
//		JobSeekerPersonal jsPersonal = jobSeekerRepo.findByEmail(email);
		
		Login login = loginRepo.findByEmail(email);
		
		jsEducationalDetails.setHSC_result(educationalDetails.getHSC_result());
		jsEducationalDetails.setSSC_result(educationalDetails.getSSC_result());
		jsEducationalDetails.setUniversity_name(educationalDetails.getUniversity_name());
		jsEducationalDetails.setStart_date(educationalDetails.getStart_date());
		jsEducationalDetails.setEnd_date(educationalDetails.getEnd_date());
		jsEducationalDetails.setPercentage(educationalDetails.getPercentage());
		jsEducationalDetails.setCgpa(educationalDetails.getCgpa());
		jsEducationalDetails.setLogin(login);
		educationalDetailsReo.save(jsEducationalDetails);
	}


	@Override
	public JobSeekerEducationalDetailsResponse getEducationalDetails(Principal principal) {
		JobSeekerEducationalDetailsResponse educationalDetailsResponse =
				new JobSeekerEducationalDetailsResponse();
		
		String email = principal.getName();
		System.out.println(email);
		
		Login login = loginRepo.findByEmail(email);
		
		JobSeekerEducationDetails educationalDetails = 
				educationalDetailsReo.findByLogin(login);
		
		educationalDetailsResponse.setHSC_result(educationalDetails.getHSC_result());
		educationalDetailsResponse.setSSC_result(educationalDetails.getSSC_result());
		educationalDetailsResponse.setUniversity_name(educationalDetails.getUniversity_name());
		educationalDetailsResponse.setStart_date(educationalDetails.getStart_date());
		educationalDetailsResponse.setEnd_date(educationalDetails.getEnd_date());
		educationalDetailsResponse.setCgpa(educationalDetails.getCgpa());
		educationalDetailsResponse.setHSC_result(educationalDetails.getHSC_result());
		return educationalDetailsResponse;
	}


	@Override
	public void updateEducationalDetails(JobSeekerEducationalDetailRequest educationalDetailsRequest, 
			Principal principal) {
		saveEducationalDetails(educationalDetailsRequest, principal);	
	}
	
	/*
	 * Below method needs check and changes
	 */
	@Override
	public void deleteEducationalDetails(Long education_id, Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		
		Login login = loginRepo.findByEmail(email);
		
		JobSeekerEducationDetails educationalDetails = 
				educationalDetailsReo.findByLogin(login);
		educationalDetailsReo.deleteById(education_id);
	}
} // end of class
