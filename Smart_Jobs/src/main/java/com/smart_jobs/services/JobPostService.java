package com.smart_jobs.services;

import java.util.List;
import java.util.Optional;

import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.web.model.JobPost;
/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description services for job post
 * 
 */
public interface JobPostService {

	public List<JobPost> findAllJobs() throws JobPostNotFound;
	public JobPost findJobById(long id) throws JobPostNotFound;
	public String updateJob(JobPost job) throws JobPostNotFound;
	
	//public JobPost findJobById(int id) throws JobPostNotFound;
	
//	public List<JobPost> findJobByCompany(String cname) throws JobPostNotFound;
//	
//	public List<JobPost> findJobBySkills(String skills) throws JobPostNotFound;
	
	public List<JobPost> findJobBySalary(float salary) throws JobPostNotFound;
	
	public List<JobPost> findJobBySalaryInRange(float minsalary,float maxsalary) throws JobPostNotFound;
	
//	public List<JobPost> findJobBySkillsAndSalary(String sname,float salary) throws JobPostNotFound;
//
//	public List<JobPost> findJobBySkillsAndCompany(String sname,String cname) throws JobPostNotFound;
//	
	String addJob(JobPost job);
	
	public String deleteJob(long id) throws JobPostNotFound;
	
//	public String deleteJobBySkills(Optional<JobPost> jb,JobPost job,String skills) throws JobPostNotFound;
//	
//	public String deleteJobByCompany(Optional<JobPost> jb,JobPost job,String cname) throws JobPostNotFound;
}
