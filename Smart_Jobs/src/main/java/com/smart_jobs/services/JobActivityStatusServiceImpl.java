package com.smart_jobs.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.AlreadyApplied;
import com.smart_jobs.exceptions.JobActivityStatusNotFound;
import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.repository.JobActivityRepository;
import com.smart_jobs.repository.JobPostRepository;
import com.smart_jobs.repository.JobSeekerPersonalRepo;
import com.smart_jobs.web.model.JobActivityStatus;
import com.smart_jobs.web.model.JobPost;
import com.smart_jobs.web.model.JobSeekerPersonal;

/*
 * @author Mehul Thakor, bhargav.parmar@stltech.in
 * @version 2.0
 * @creation date 9-sept-2021, @update 28-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description services for job activity status
 * @update_description findAppliedJobs is created which
 * 						returns the job applied by jobseeker
 * 						No use of spring security that's why 
 * 						directly fetching the full column of 
 * 						jobPostId
 */
@Service
public class JobActivityStatusServiceImpl implements JobActivityStatusService {

	@Autowired
	private JobActivityRepository activityRepo;
	
	@Autowired
	private JobPostRepository jobPostRepo;
	
	@Autowired
	private JobSeekerPersonalRepo jobskRepo;

	JobActivityStatus statusObj = new JobActivityStatus();

	@Override
	public JobActivityStatus findActivityStatus(Long id) throws JobActivityStatusNotFound {
		return activityRepo.findById(id).get();
	}

	// change in type int -> BigInteger
	public List<JobActivityStatus> findStatusByJobId(Long jid) throws JobActivityStatusNotFound {
		return activityRepo.findByJobPost(jid);
	}

	public List<JobActivityStatus> findActivityStatusByStatus(String astatus) throws JobActivityStatusNotFound {
		return activityRepo.findByJobStatus(astatus);
	}

	// create job activity status for user
	public String addActivityStatus(JobActivityStatus activity) {
		activity = activityRepo.save(activity);
		return "Job activity status " + activity.getJobStatusId() + " is added successfully";
	}

	// Update job activity status for user
	public String updateActivityStatus(String status) {
		statusObj.setJobStatus(status);
		return "Job activity status " + statusObj.getJobStatusId() + " is updated successfully";
	}

	// Add reject date for rejected user
	public String AddRejectDate(Date date) {
		statusObj.setRejectedDate(date);
		return "Reject date for " + statusObj.getJobStatusId() + " is added successfully";
	}
	
	/*
	 * Find all jobs applied by jobseeker
	 * 
	 * There is only one user because we are not using security.
	 * 
	 * @description In this method I've wrote query to get full column 
	 * 				of JobPostId to get all the jobpost from 
	 * 				JobPostRepository.
	 * Changes are made in terms of datatypes of the variables
	 */
	@Override
	public List<JobPost> findAppliedJobs() throws JobPostNotFound {
		
		List<JobPost> jobPosts = new ArrayList<JobPost>();
		
		List<Long> jobPostId = activityRepo.getJobPostId();
		
		// debug
		System.out.println(jobPostId);
		
		for(Long i:jobPostId) {
			jobPosts = jobPostRepo.findByJobPostId(i);
		}
		return jobPosts;
	}

	@Override
	public void applyJobs(JobActivityStatus appliedRequest) throws AlreadyApplied {
		
//		JobActivityStatus appliedJobs = new JobActivityStatus();
//		
//		appliedJobs.setJspersonal(appliedRequest.getJspersonal());
//		appliedJobs.setJobPost(appliedRequest.getJobPost());
//		appliedJobs.setApplyDate(appliedRequest.getApplyDate());
//		appliedJobs.setRejectedDate(appliedRequest.getRejectedDate());
//		appliedJobs.setJobStatus(appliedRequest.getJobStatus());
		JobSeekerPersonal js = jobskRepo.findByLogin_UserId(appliedRequest.getJspersonal().getLogin().getUserId()).get();
		JobActivityStatus jas = activityRepo.findByJobPost_JobPostIdAndJspersonal_SrNo(appliedRequest.getJobPost().getJobPostId(), js.getSrNo());
		System.out.println("postId" + appliedRequest.getJobPost());
		System.out.println("seekerId" + appliedRequest.getJspersonal());
		System.out.println("jas"+ jas);
		if(jas == null) {
			System.out.println(appliedRequest);
			appliedRequest.setJspersonal(js);
			appliedRequest.setJobPost(jobPostRepo.getById(appliedRequest.getJobPost().getJobPostId()));
			activityRepo.save(appliedRequest);
		}else {
			throw new AlreadyApplied("Already Applied!!!");
		}
		
	}

	@Override
	public String deleteActivityStatus(Long jobASId) throws JobActivityStatusNotFound {
		// TODO Auto-generated method stub
		Optional<JobActivityStatus> joas = activityRepo.findById(jobASId);
		if(joas.isPresent()) {
			activityRepo.delete(joas.get());
			return "JobPost Deleted Successfully";
		}
		else {
			throw new JobActivityStatusNotFound("Sorry!!! JobPostActivityStatus Not found");
		}
	}

}
