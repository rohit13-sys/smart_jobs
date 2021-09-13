package com.smart_jobs.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.service.JobSeekerExperienceService.JobSeekerExperienceDetailsService;
import com.smart_jobs.web.dto.JobSeekerExperienceDetailsRequest;
import com.smart_jobs.web.dto.JobSeekerExperienceDetailsResponse;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@RestController
@RequestMapping("/api/v1/experience")
public class JobSeekerExperienceDetailsController {
	
	@Autowired
	private JobSeekerExperienceDetailsService jobSeekerExperienceDetailsService;
	
	@PostMapping("/saveExperienceDetails")
	public ResponseEntity<String> saveExperienceDetails(
			@RequestBody JobSeekerExperienceDetailsRequest 
				experienceDetailsRequest, Principal principal){
		jobSeekerExperienceDetailsService.saveExperienceDetails(experienceDetailsRequest, principal);
		return new ResponseEntity<>("Experience Details Saved.", HttpStatus.OK);	
	}
	
	@GetMapping("/getExperienceDetails")
	public JobSeekerExperienceDetailsResponse getExperienceDetails(Principal principal){
		return jobSeekerExperienceDetailsService.getExperienceDetails(principal);
	}
	
	@PostMapping("/updateExperienceDetails")
	public ResponseEntity<String> updateExperienceDetails(
			@RequestBody JobSeekerExperienceDetailsRequest 
			experienceDetailsRequest, Principal principal){
		jobSeekerExperienceDetailsService.updateExperienceDetails(experienceDetailsRequest, principal);
		return new ResponseEntity<>("Experience Details is Updated.", HttpStatus.OK);	
	}
	
	@PostMapping("/deleteExperienceDetails/{exp_id}")
	public ResponseEntity<String> deleteExperienceDetails(@PathVariable Long exp_id, Principal principal){
		jobSeekerExperienceDetailsService.deleteExperienceDetails(exp_id, principal);
		return new ResponseEntity<>("Experience Details Deleted.", HttpStatus.OK);	
	}

}
