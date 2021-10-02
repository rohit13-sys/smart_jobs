package com.smart_jobs.web.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.services.JobPostService;
import com.smart_jobs.web.model.JobPost;
/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description RESTful web service for job post
 * 
 */
@CrossOrigin(origins = "*")
@RequestMapping("/jobpost")
@RestController
public class JobPostController {

	@Autowired
	private JobPostService jobServiceRepo;
	
	@GetMapping
	public List<JobPost> getAllJobs() throws JobPostNotFound{
		return jobServiceRepo.findAllJobs();
	}
	
	@GetMapping("/findjbyid/{id}")
	public Object getJobById(@PathVariable("id") long jobPostId){
		try {
			return jobServiceRepo.findJobById(jobPostId);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
	@PostMapping("/updateJob")
	public String updateJobById(@RequestBody JobPost job) {
		try {
			return jobServiceRepo.updateJob(job);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
//	@GetMapping("/findjbycom")
//	public List<JobPost> getJobByCompany(@RequestParam("cname") String cname) throws JobPostNotFound{
//		return jobServiceRepo.findJobByCompany(cname);
//	}
//	
//	@GetMapping("/findjbyskills")
//	public List<JobPost> getJobBySkills(@RequestParam("skill") String skill) throws JobPostNotFound{
//		return jobServiceRepo.findJobBySkills(skill);
//	}
	
	@GetMapping("/findjbysl")
	public List<JobPost> getJobBySalary(@RequestParam("salary") float salary) throws JobPostNotFound{
		return jobServiceRepo.findJobBySalary(salary);
	}
	
	@GetMapping("/findjbyslrange")
	public List<JobPost> getJobBySalaryInRange(@RequestParam("minsalary") float minsalary,@RequestParam("maxsalary") float maxsalary) throws JobPostNotFound{
		return jobServiceRepo.findJobBySalaryInRange(minsalary,maxsalary);
	}
	
//	@GetMapping("/findjbysksl")
//	public List<JobPost> getJobBySkillAndSalary(@RequestParam("skills") String skills,@RequestParam("salary") float salary) throws JobPostNotFound{
//		return jobServiceRepo.findJobBySkillsAndSalary(skills,salary);
//	}
//	
//	@GetMapping("/findjbyskcp")
//	public List<JobPost> getJobBySkillAndCompany(@RequestParam("skills") String skills,@RequestParam("company") String company) throws JobPostNotFound{
//		return jobServiceRepo.findJobBySkillsAndCompany(skills,company);
//	}
	
	
	//Post new job if new id or update existing job
	@PostMapping("/addjob")
	public ResponseEntity<String> addJob(@RequestBody JobPost job) {
		System.out.println(job); 
		jobServiceRepo.addJob(job);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
		
	 @DeleteMapping("/delete/{id}") 
	  public String deleteJobById(@PathVariable("id") int id){
	      try {
			return jobServiceRepo.deleteJob(id);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	  }
	
	 @PostMapping("/findByEmail")
	 public List<JobPost> findJobByEmpEmail(@RequestParam("email") String emailId){
		 try {
			return jobServiceRepo.findJobPostByEmail(emailId);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	 }
	 
//	@DeleteMapping("/deletebyskills")s
//	public void deleteJobBySkill(Optional<JobPost> jb,JobPost job,@RequestParam("skills") String skills) throws JobPostNotFound {
//		 jobServiceRepo.deleteJobBySkills(jb, job, skills);
//	}
//	
//	@DeleteMapping("/deletebycompany")
//	public void deleteJobByCname(Optional<JobPost> jb,JobPost job,@RequestParam("company") String company) throws JobPostNotFound {
//		 jobServiceRepo.deleteJobByCompany(jb, job, company);
//	}
}
