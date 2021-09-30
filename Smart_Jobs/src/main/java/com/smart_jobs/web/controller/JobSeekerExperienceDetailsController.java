package com.smart_jobs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.services.JobSeekerExperienceDetailsService;
import com.smart_jobs.web.model.JobSeekerExperienceDetails;

/*
 * @author bhargav.parmar@stltech.in
 * @version 2.0
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
			@RequestBody JobSeekerExperienceDetails 
				experienceDetailsRequest){
		jobSeekerExperienceDetailsService.saveExperienceDetails(experienceDetailsRequest);
		return new ResponseEntity<>("Experience Details Saved.", HttpStatus.OK);	
	}
	
	@GetMapping("/getExperienceDetails")
	public JobSeekerExperienceDetails getExperienceDetails(){
		return jobSeekerExperienceDetailsService.getExperienceDetails();
	}
	
	@PostMapping("/updateExperienceDetails")
	public ResponseEntity<String> updateExperienceDetails(
			@RequestBody JobSeekerExperienceDetails 
			experienceDetailsRequest){
		jobSeekerExperienceDetailsService.updateExperienceDetails(experienceDetailsRequest);
		return new ResponseEntity<>("Experience Details is Updated.", HttpStatus.OK);	
	}
	
	@PostMapping("/deleteExperienceDetails/{exp_id}")
	public ResponseEntity<String> deleteExperienceDetails(@PathVariable Long exp_id){
		jobSeekerExperienceDetailsService.deleteExperienceDetails(exp_id);
		return new ResponseEntity<>("Experience Details Deleted.", HttpStatus.OK);	
	}

}
