package com.smartjobs.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.smartjobs.entities.JobPost;
import com.smartjobs.exceptions.JobPostNotFound;
import com.smartjobs.repositories.JobPostRepository;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description services for job post
 * 
 */
@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	private JobPostRepository jobPostRepo;
	
	public List<JobPost> findAllJobs(){
		return jobPostRepo.findAll();
	}
	
	public Object findJobById(int id) throws JobPostNotFound{
		JobPost job = new JobPost();
		Optional<JobPost> op = jobPostRepo.findById(id);
		if(op.isPresent()) {
			return op.get();}
	   else
			return "sorry! job is not found";
		
	}
	
	public List<JobPost> findJobByCompany(String cname) throws JobPostNotFound{
		return jobPostRepo.findByCompany(cname);
	}
	
	/*
	 * public Optional<JobPost> findJobBySkills(String skills) throws
	 * JobPostNotFound{ return jobPostRepo.findBySkill(skills); }
	 */
	
	public List<JobPost> findJobBySalary(float salary) throws JobPostNotFound{
		return jobPostRepo.findBySalary(salary);
	}
	
	public List<JobPost> findJobBySalaryInRange(float minsalary,float maxsalary) throws JobPostNotFound{
		return jobPostRepo.findBySalaryBetween(minsalary,maxsalary);
	}
	
	public List<JobPost> findJobBySkillsAndSalary(String sname,float salary) throws JobPostNotFound{
		return jobPostRepo.findBySkillsAndSalary(sname,salary);
	}

	public String addJob(JobPost job) {
	job = jobPostRepo.save(job);
	return "Job " + job.getJobPostId() + " is posted successfully";
	}
	
	public String updateJob(@RequestBody JobPost job) {
	    Optional<JobPost> op = jobPostRepo.findById(job.getJobPostId());
	if(op.isPresent()) {
		job=jobPostRepo.save(job);
		return "Job "+job.getJobPostId()+" is updated successfully";}
   else
		return "sorry! job is not found";
	}

	  public String deleteJob(JobPost job) throws JobPostNotFound
	  { 
		  Optional<JobPost> jp = jobPostRepo.findById(job.getJobPostId());
		  if(jp.isPresent()) { 
			  jobPostRepo.delete(job);
			  return "Job " + job.getJobPostId() +" is deleted successfully";
	  }
	   else  return "sorry!Product not found"; }
	  
	  public String deleteJob(int id) throws JobPostNotFound {
		  Optional<JobPost> op = jobPostRepo.findById(id);
			if(op.isPresent()) {
				JobPost job = op.get();
				jobPostRepo.delete(job);
	            return "job "+ job.getJobPostId()+ " deleted successfully";}
			 else
					return "sorry! Job is not found";
				}
	  
}
