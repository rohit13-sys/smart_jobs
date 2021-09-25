package com.smartjobs.controllers;

import java.io.Console;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smartjobs.entities.JobPost;
import com.smartjobs.exceptions.JobPostNotFound;
import com.smartjobs.services.JobPostService;
/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description RESTful web service for job post
 * 
 */
@RequestMapping("/jobpost")
@RestController
public class JobPostController {

	@Autowired
	private JobPostService jobServiceRepo;
	
	@GetMapping
	public List<JobPost> getAllJobs() {
		return jobServiceRepo.findAllJobs();
	}
	
	@GetMapping("/findjbyid/{id}")
	public Object getJobById(@PathVariable("id") int jobPostId){
		try {
			return jobServiceRepo.findJobById(jobPostId);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
	//Post new job if new id or update existing job
	@PutMapping("/addjob")
	public String addJob(@RequestBody JobPost job) {
		 jobServiceRepo.addJob(job);
		 return "job posted successfully";
	}
	
	//update existing product
	@PostMapping("/updatejob/{id}")
	public String updateJobById(@RequestBody JobPost job) {
		try {
			return jobServiceRepo.updateJob(job);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
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
	  
	  @GetMapping("/findjbysl")
		public List<JobPost> getJobBySalary(@PathVariable("salary") float salary) throws JobPostNotFound{
			return jobServiceRepo.findJobBySalary(salary);
		}
		
	  @GetMapping("/findjbyslrange")
		public List<JobPost> getJobBySalaryInRange(@PathVariable("minsalary") float minsalary,@PathVariable("maxsalary") float maxsalary) throws JobPostNotFound{
			return jobServiceRepo.findJobBySalaryInRange(minsalary,maxsalary);
		}
		

}


