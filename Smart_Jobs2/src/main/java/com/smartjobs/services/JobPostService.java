package com.smartjobs.services;

import java.util.List;
import java.util.Optional;

import com.smartjobs.entities.JobPost;
import com.smartjobs.exceptions.JobPostNotFound;
/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description services for job post
 * 
 */
public interface JobPostService {

	public List<JobPost> findAllJobs();
	
	public Object findJobById(int id) throws JobPostNotFound;
	
	public String updateJob(JobPost job) throws JobPostNotFound;
	
	public List<JobPost> findJobBySalary(float salary) throws JobPostNotFound;
	
	public List<JobPost> findJobBySalaryInRange(float minsalary,float maxsalary) throws JobPostNotFound;
	
	public List<JobPost> findJobBySkillsAndSalary(String sname,float salary) throws JobPostNotFound;

	String addJob(JobPost job);
	
	public String deleteJob(JobPost job) throws JobPostNotFound;
	  
	public String deleteJob(int id) throws JobPostNotFound;
	 
}
