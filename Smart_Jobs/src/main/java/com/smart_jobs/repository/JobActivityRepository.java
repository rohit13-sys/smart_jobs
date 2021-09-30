package com.smart_jobs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smart_jobs.web.model.JobActivityStatus;
/*
 * @author Mehul Thakor,Parth Panchal,Rohit Khatwani, 
 * 			bhargav.parmar@stltech.in
 * @version 2.0
 * @creation date 9-sept-2021, @update_date 28-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description Job Activity status Repo.
 * @update_desc created custom query and method for getJobPostId
 * 				this will return the column of Job Post Id.
 * 
 */
public interface JobActivityRepository extends JpaRepository<JobActivityStatus, Integer> {

	List<JobActivityStatus> findById(int id);
	List<JobActivityStatus> findByJobPost(Long i);
	List<JobActivityStatus> findByJobStatus(String status);
	JobActivityStatus findByJobPost_JobPostIdAndJspersonal_SrNo(Long jobPostId,Long jobSeekerId);
	/*
	 * Finding all the applied jobs using Job seeker email
	 * 
	 * Below method will be used in case of spring security because
	 * her we are using only one user so no need to check which user is logged in.
	 */
//	List<JobPost> findByJobSeekerEmail(String email);
	
	/*
	 * Finding all the applied jobs using Job seeker email
	 * 
	 * Below method will be used in this case cause only one user
	 * is there so no need to check any email.
	 * 
	 * query that will return list
	 * select j.jobPostId from JobActivityStatus j
	 */
	@Query("select j.jobPost.jobPostId from JobActivityStatus j")
	List<Long> getJobPostId();
			
}
