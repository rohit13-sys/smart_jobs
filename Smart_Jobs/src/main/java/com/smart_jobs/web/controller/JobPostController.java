package com.smart_jobs.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.services.jobpost.JobPostService;
import com.smart_jobs.web.model.JobPost;

/*
 * @author Mehul Thakor,Parthkumar Panchal,Rohit Khatwani
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description RESTful web service for job post
 * 
 */
@CrossOrigin
@RequestMapping("/jobpost")
@RestController
public class JobPostController {

	@Autowired
	private JobPostService jobServiceRepo;

	@GetMapping
	public List<JobPost> getAllJobs() throws JobPostNotFound {
		return jobServiceRepo.findAllJobs();
	}

	@GetMapping("/findjbyid")
	public ResponseEntity<Object> getJobById(@RequestParam("id") int id)  {
		try {
			Optional<JobPost> job=this.jobServiceRepo.findJobById(id);
			return new ResponseEntity<Object>(job,HttpStatus.OK);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>("Sorry no content!!!",HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/findjbysl")
	public ResponseEntity<Object> getJobBySalary(@RequestParam("salary") float salary) {
		try {
			List<JobPost> job=jobServiceRepo.findJobBySalary(salary);
			return new ResponseEntity<Object>(job,HttpStatus.OK);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/findjbyslrange")
	public List<JobPost> getJobBySalaryInRange(@RequestParam("minsalary") float minsalary,
			@RequestParam("maxsalary") float maxsalary) throws JobPostNotFound {
		return jobServiceRepo.findJobBySalaryInRange(minsalary, maxsalary);
	}

	// Post new job if new id or update existing job
	@PostMapping("/addjob")
	public ResponseEntity<Object> addJob(@RequestBody JobPost job) {
		this.jobServiceRepo.addJob(job);
		return new ResponseEntity<Object>("Job posted successfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/deletebyid")
	public ResponseEntity<Object> deleteJobById(Optional<JobPost> jb, JobPost job, @RequestParam("id") int id) {
		try {
			this.jobServiceRepo.deleteJobById(jb, job, id);
		} catch (JobPostNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
