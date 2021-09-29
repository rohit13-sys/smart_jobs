package com.smart_jobs.services.JobSeekerEductionalService;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerEducationalDetailsRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobSeekerEducationDetails;
import com.smart_jobs.web.model.Login;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
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

		Login login = loginRepo.findByUserIdAndPwd(jsEducation.getLogin().getUserId(),
				jsEducation.getLogin().getPwd());

		jsEducation.setHSC_result(jsEducation.getHSC_result());
		jsEducation.setSSC_result(jsEducation.getSSC_result());
		jsEducation.setUniversity_name(jsEducation.getUniversity_name());
		jsEducation.setStart_date(jsEducation.getStart_date());
		jsEducation.setEnd_date(jsEducation.getEnd_date());
		jsEducation.setPercentage(jsEducation.getPercentage());
		jsEducation.setCgpa(jsEducation.getCgpa());
		jsEducation.setLogin(jsEducation.getLogin());
		educationalDetailsReo.save(jsEducation);
	}

//	@Override
//	public JobSeekerEducationDetails getEducationalDetails(Principal principal) {
//		
//		String email = principal.getName();
//		System.out.println(email);
//
//		Login login = loginRepo.findByEmail(email);
//
//		JobSeekerEducationDetails educationalDetails = educationalDetailsReo.findByLogin(login);
//
//		educationalDetailsResponse.setHSC_result(educationalDetails.getHSC_result());
//		educationalDetailsResponse.setSSC_result(educationalDetails.getSSC_result());
//		educationalDetailsResponse.setUniversity_name(educationalDetails.getUniversity_name());
//		educationalDetailsResponse.setStart_date(educationalDetails.getStart_date());
//		educationalDetailsResponse.setEnd_date(educationalDetails.getEnd_date());
//		educationalDetailsResponse.setCgpa(educationalDetails.getCgpa());
//		educationalDetailsResponse.setHSC_result(educationalDetails.getHSC_result());
//		return educationalDetailsResponse;
//	}

	@Override
	public void updateEducationalDetails(JobSeekerEducationDetails jsEducation) {
		saveEducationalDetails(jsEducation);
	}

	/*
	 * Below method needs check and changes
	 */
//	@Override
//	public void deleteEducationalDetails(Long education_id) {
//		String email = principal.getName();
//		System.out.println(email);
//
//		Login login = loginRepo.findByEmail(email);
//
//		JobSeekerEducationDetails educationalDetails = educationalDetailsReo.findByLogin(login);
//		educationalDetailsReo.deleteById(education_id);
//	}
} // end of class
