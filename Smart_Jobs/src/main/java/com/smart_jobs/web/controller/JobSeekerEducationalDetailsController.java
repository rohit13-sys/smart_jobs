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

import com.smart_jobs.service.JobSeekerEductionalService.JobSeekerEducationalDetailsService;
import com.smart_jobs.web.dto.JobSeekerEducationalDetailRequest;
import com.smart_jobs.web.dto.JobSeekerEducationalDetailsResponse;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@RestController
@RequestMapping("api/v1/educational")
public class JobSeekerEducationalDetailsController {
	
	@Autowired
	private JobSeekerEducationalDetailsService jobSeekerEducationalDetailsService;
	
	@PostMapping("/saveEducationalDetails")
	public ResponseEntity<String> saveEducationalDetails(
			@RequestBody JobSeekerEducationalDetailRequest jobSeekerEducationalDetailRequest,
			Principal principal){
		jobSeekerEducationalDetailsService.saveEducationalDetails(jobSeekerEducationalDetailRequest, principal);
		return new ResponseEntity<>("Educational Details are saved.", HttpStatus.OK);	
	}
	
	@GetMapping("/getEducationalDetails")
	public JobSeekerEducationalDetailsResponse getEducationalDetails(Principal principal){
		return jobSeekerEducationalDetailsService.getEducationalDetails(principal);	
	}
	
	@PostMapping("/updateEducationalDetails")
	public ResponseEntity<String> updateEducationalDetails(
			@RequestBody JobSeekerEducationalDetailRequest jobSeekerEducationalDetailRequest,
			Principal principal){
		return new ResponseEntity<>("Educational Details updated.", HttpStatus.OK);	
	}
	
	@PostMapping("/deleteEducationalDetails/{education_id}")
	public ResponseEntity<String> deleteEducationalDetails(@PathVariable Long education_id,Principal principal){
		jobSeekerEducationalDetailsService.deleteEducationalDetails(education_id, principal);
		return new ResponseEntity<>("Educational Details are deleted.", HttpStatus.OK);	
	}
}
