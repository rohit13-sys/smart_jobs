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

	public List<JobPost> findAllJobs() throws JobPostNotFound;
	
	public List<JobPost> findJobById(int id) throws JobPostNotFound;
	
	public List<JobPost> findJobByCompany(String cname) throws JobPostNotFound;
	
	public List<JobPost> findJobBySkills(String skills) throws JobPostNotFound;
	
	public List<JobPost> findJobBySalary(float salary) throws JobPostNotFound;
	
	public List<JobPost> findJobBySalaryInRange(float minsalary,float maxsalary) throws JobPostNotFound;
	
	public List<JobPost> findJobBySkillsAndSalary(String sname,float salary) throws JobPostNotFound;

	public List<JobPost> findJobBySkillsAndCompany(String sname,String cname) throws JobPostNotFound;
	
	String addJob(JobPost job);
	
	public String deleteJobById(Optional<JobPost> jb,JobPost job,int id) throws JobPostNotFound;
	
	public String deleteJobBySkills(Optional<JobPost> jb,JobPost job,String skills) throws JobPostNotFound;
	
	public String deleteJobByCompany(Optional<JobPost> jb,JobPost job,String cname) throws JobPostNotFound;
}
