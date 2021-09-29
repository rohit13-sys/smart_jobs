package com.smart_jobs.services.JobSeekerExperienceService;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.smart_jobs.repository.JobSeekerExperienceDetailsRepo;
import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.JobSeekerExperienceDetails;
import com.smart_jobs.web.model.Login;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

/*
 * I have to add Principal to get the current user id 
 * so that I can set foreign key.
 * 
 * Right now there is no FK set.
 * 
 *  @IntroOfPrincipal: The principal is the currently logged in user. 
 *  	However, you retrieve it through the security context which 
 *  	is bound to the current thread and as such it's also bound 
 *  	to the current request and its session.SecurityContextHolder.getContext() 
 *  	internally obtains the current SecurityContext implementation through a ThreadLocal 
 *  	variable. Because a request is bound to a single thread this will get you the context 
 *  	of the current request.To simplify you could say that the security context is 
 *  	in the session and contains user/principal and roles/authorities.
 *  	
 *  How do I retrieve a specific user? 
 *  	You don't. All APIs are designed to allow access to the user 
 *  	& session of the current request. Let user A be one of 100 
 *  	currently authenticated users. If A issues a request against your 
 *  	server it will allocate one thread to process that request. 
 *  	If you then do SecurityContextHolder.getContext().getAuthentication() 
 *  	you do so in the context of this thread. By default from within 
 *  	that thread you don't have access to the context of user B which 
 *  	is processed by a different thread.
 *	
 *	How do I differentiate between users that are doing requests?
 *		You don't have to, that's what the Servlet container does for you.
 */

public class JobSeekerExperienceDetailsImpl implements JobSeekerExperienceDetailsService{

	@Autowired
	private JobSeekerExperienceDetailsRepo experienceDetailsRepo;
	
	@Autowired
	private LoginRepo loginRepo;
	
//	@Override
//	public void saveExperienceDetails(JobSeekerExperienceDetails jsExperience, 
//										Principal principal) {
//		String email = principal.getName();
//		System.out.println(email);
//		
//		Optional<Login> login = loginRepo.findByUserIdAndPwd(jsExperience.getLogin().getUserId(), jsExperience.getLogin().getPwd());
//		
//		JobSeekerExperienceDetails jsExperienceDetails = 
//				new JobSeekerExperienceDetails();
//		jsExperienceDetails.setCompany_name(jsExperience.getCompany_name());
//		jsExperienceDetails.setIs_current_Active(jsExperience.getIs_current_Active());
//		jsExperienceDetails.setYear_of_exp(jsExperience.getYear_of_exp());
//		jsExperienceDetails.setJob_title(jsExperience.getJob_title());
//		jsExperienceDetails.setDescription(jsExperience.getDescription());
//		jsExperienceDetails.setLogin(jsExperience.getLogin());
//		experienceDetailsRepo.save(jsExperienceDetails);	
//	}

//	@Override
//	public JobSeekerExperienceDetails getExperienceDetails(Principal principal) {
//		JobSeekerExperienceDetailsResponse experienceDetailsResponse =
//				new JobSeekerExperienceDetailsResponse();
//		String email =  principal.getName();
//		System.out.println(email);
//		
//		Login login = loginRepo.findByEmail(email);
//		
//		// Below method needs change use Login insted of user
//		JobSeekerExperienceDetails experienceDetails 
//			= experienceDetailsRepo.findByLogin(login);
//		
//		experienceDetailsResponse.setCompany_name(experienceDetails.getCompany_name());
//		experienceDetailsResponse.setIs_current_Active(experienceDetails.getIs_current_Active());
//		experienceDetailsResponse.setYear_of_exp(experienceDetails.getYear_of_exp());
//		experienceDetailsResponse.setJob_title(experienceDetails.getJob_title());
//		experienceDetailsResponse.setDescription(experienceDetails.getDescription());
//		return experienceDetailsResponse;
//	}
	
//	@Override
//	public void updateExperienceDetails(JobSeekerExperienceDetails jsExperience,
//			Principal principal) {
//		saveExperienceDetails(jsExperience, principal);
//	}
	
//	@Override
//	public void deleteExperienceDetails(Long exp_id, Principal principal) {
//		
//		String email =  principal.getName();
//		System.out.println(email);
//		
//		Login login = loginRepo.findByUserIdAndPwd();
//		
//		JobSeekerExperienceDetails experienceDetails 
//			= experienceDetailsRepo.findByLogin(login);
//		
//		// There will be changes after testing.
//				
//		experienceDetailsRepo.deleteById(exp_id);
//	}
}
