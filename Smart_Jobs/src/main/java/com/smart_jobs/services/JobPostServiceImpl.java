package com.smart_jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.repository.EmployerRepository;
import com.smart_jobs.repository.JobPostRepository;
import com.smart_jobs.repository.SkillsRepo;
import com.smart_jobs.web.model.JobPost;
import com.smart_jobs.web.model.Skills;

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
	
	@Autowired
	private SkillsRepo skillsRepo;
	
	@Autowired
	private EmployerRepository employerRepo;
	public List<JobPost> findAllJobs() throws JobPostNotFound{
		return jobPostRepo.findAll();
	}
	
	public JobPost findJobById(int id) throws JobPostNotFound{
		return jobPostRepo.findById(id).get();
	}
	
//	public List<JobPost> findJobByCompany(String cname) throws JobPostNotFound{
//		return jobPostRepo.findByCompany(cname);
//	}
//	
//	public List<JobPost> findJobBySkills(String skills) throws JobPostNotFound{
//		return jobPostRepo.findBySkills(skills);
//	}
	
	public List<JobPost> findJobBySalary(float salary) throws JobPostNotFound{
		return jobPostRepo.findBySalary(salary);
	}
	
	public List<JobPost> findJobBySalaryInRange(float minsalary,float maxsalary) throws JobPostNotFound{
		return jobPostRepo.findBySalaryBetween(minsalary,maxsalary);
	}
	
//	public List<JobPost> findJobBySkillsAndSalary(String sname,float salary) throws JobPostNotFound{
//		return jobPostRepo.findBySkillsAndSalary(sname,salary);
//	}
//
//	public List<JobPost> findJobBySkillsAndCompany(String sname,String cname) throws JobPostNotFound{
//		return jobPostRepo.findBySkillsAndCompany(sname,cname);
//	}
	
	public String addJob(JobPost job) {
		job.setEmployee(employerRepo.findByLogin_UserId(job.getEmployee().getLogin().getUserId()).get());
		job = jobPostRepo.save(job);
		for(Skills skill : job.getSkills()) {
			skill.setJobPostId(job);
			skill.setLogin(job.getEmployee().getLogin());
			skillsRepo.save(skill);
		}
		
		return "Job " + job.getJobPostId() + " is posted successfully";
	}
	
	public String deleteJobById(Optional<JobPost> jb,JobPost job,int id) throws JobPostNotFound{
		jb = jobPostRepo.findById(id);
		if(jb.isPresent()) {
			 job = jb.get();
			 jobPostRepo.delete(job);
			 return "Job for " + job.getJobPostId() + " is deleted successfully";}
		else {
			return "Product not found";
		}
	}
	
//	public String deleteJobBySkills(Optional<JobPost> jb,JobPost job,String skills) throws JobPostNotFound{
//		jb = jobPostRepo.findBySkill(skills);
//		if(jb.isPresent()) {
//			 job = jb.get();
//			 jobPostRepo.delete(job);
//			 return "Job for " + job.getSkills() + " is deleted successfully";}
//		else {
//			return "Product not found";
//		}
//			
//	}
//	
//	public String deleteJobByCompany(Optional<JobPost> jb,JobPost job,String cname) throws JobPostNotFound{
//		jb = jobPostRepo.findByComapany(cname);
//		if(jb.isPresent()) {
//			 job = jb.get();
//			 jobPostRepo.delete(job);
//			 return "Job for " + job.getCompany() + " is deleted successfully";}
//		else {
//			return "Product not found";
//		}
//	}
}
