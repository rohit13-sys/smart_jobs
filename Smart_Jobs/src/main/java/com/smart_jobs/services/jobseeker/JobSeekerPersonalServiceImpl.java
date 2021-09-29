package com.smart_jobs.services.jobseeker;

import java.security.Principal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.JobSeekerPersonalRepo;
import com.smart_jobs.repository.LoginRepo;
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
	public void saveJobSeeker(JobSeekerPersonal jsPersonal) {

		// Get current user/jobseeker
//		String email = principal.getName();
//		System.out.println(email); // debug

		// updated
		Login login = loginRepo.findByUserIdAndPwd(jsPersonal.getLogin().getUserId(),
				jsPersonal.getLogin().getPwd());

		JobSeekerPersonal jobSeeker = new JobSeekerPersonal();
		jobSeeker.setSeeker_name(jsPersonal.getSeeker_name());
		jobSeeker.setPh_no(jsPersonal.getPh_no());
		jobSeeker.setPhoto(jsPersonal.getPhoto());
		jobSeeker.setResume(jsPersonal.getResume());
		jobSeeker.setLogin(login);
		jobSeekerRepo.save(jobSeeker);
	}

//	@Override
//	public JobSeekerPersonal getJobSeeker() {
//		String email = principal.getName();
//		System.out.println(email);

		// updated
//		Login login = loginRepo.findByEmail(email);
//		Login login = loginRepo.findByUserIdAndPwd(jsPersonal.getLogin().getUserId(),
//				jsPersonal.getLogin().getPwd());

		// Getting Details using foreign key "Login"
//		JobSeekerPersonal personalDetails = (JobSeekerPersonal) jobSeekerRepo.findAll();

//		JobSeekerPersonal personalResponse = new JobSeekerPersonal();
//		personalResponse.setSeeker_name(personalDetails.getSeeker_name());
//		personalResponse.setPh_no(personalDetails.getPh_no());
//		personalResponse.setPhoto(personalDetails.getPhoto());
//		personalResponse.setResume(personalDetails.getResume());
//		return personalResponse;
//	}

	@Override
	public void updateJobSeeker(JobSeekerPersonal jsPersonal) {
		saveJobSeeker(jsPersonal);
	}

	/*
	 * Below method needs check and changes
	 */
	@Override
	public void deleteJobSeeker(Long sr_no) {
//		String email = principal.getName();
//		System.out.println(email);
		jobSeekerRepo.deleteById(sr_no);
	}
}
