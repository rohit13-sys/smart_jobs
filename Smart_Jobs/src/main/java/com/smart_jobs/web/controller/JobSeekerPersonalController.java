package com.smart_jobs.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.service.jobseeker.JobSeekerPersonalService;
import com.smart_jobs.web.dto.JobSeekerPersonalRequest;
import com.smart_jobs.web.dto.JobSeekerPersonalResponse;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@RestController
@RequestMapping("api/v1/personal")
public class JobSeekerPersonalController {
	
	@Autowired
	private JobSeekerPersonalService jobSeekerPersonalService;
	
	@PostMapping("/savePersonalDetails")
	public ResponseEntity<String> savePersonalDetails(
			@RequestBody JobSeekerPersonalRequest jobSeekerPersonalRequest, 
			Principal principal){
		jobSeekerPersonalService.saveJobSeeker(jobSeekerPersonalRequest, principal);
		return new ResponseEntity<>("Personal details are saved.", HttpStatus.OK);
	}
	
	@GetMapping("/getPersonalDetails")
	public JobSeekerPersonalResponse getPersonalDetails(Principal principal) {
		return jobSeekerPersonalService.getJobSeeker(principal);	
	}
	
	@PostMapping("/updatePersonalDetails")
	public ResponseEntity<String> updatePersonalDetails(
			@RequestBody JobSeekerPersonalRequest jobSeekerPersonalRequest, 
			Principal principal){
		jobSeekerPersonalService.updateJobSeeker(jobSeekerPersonalRequest, principal);
		return new ResponseEntity<>("Personal details are updated.", HttpStatus.OK);
	}
	
	@PostMapping("/deletePersonalDetails/{sr_no}")
	public ResponseEntity<String> deletePersonalDetails(Long sr_no, Principal principal){
		jobSeekerPersonalService.deleteJobSeeker(sr_no, principal);
		return new ResponseEntity<>("Personal details are deleted.", HttpStatus.OK);
	}
}
