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

import com.smart_jobs.services.JobSeekerEductionalService.JobSeekerEducationalDetailsService;
import com.smart_jobs.web.model.JobSeekerEducationDetails;

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
			@RequestBody JobSeekerEducationDetails jobSeekerEducationalDetailRequest){
		jobSeekerEducationalDetailsService.saveEducationalDetails(jobSeekerEducationalDetailRequest);
		return new ResponseEntity<>("Educational Details are saved.", HttpStatus.OK);	
	}
	
	@GetMapping("/getEducationalDetails")
	public JobSeekerEducationDetails getEducationalDetails(){
		return jobSeekerEducationalDetailsService.getEducationalDetails();	
	}
	
	@PostMapping("/updateEducationalDetails")
	public ResponseEntity<String> updateEducationalDetails(
			@RequestBody JobSeekerEducationDetails jobSeekerEducationalDetailRequest){
		return new ResponseEntity<>("Educational Details updated.", HttpStatus.OK);	
	}
	
	@PostMapping("/deleteEducationalDetails/{education_id}")
	public ResponseEntity<String> deleteEducationalDetails(@PathVariable Long education_id){
		jobSeekerEducationalDetailsService.deleteEducationalDetails(education_id);
		return new ResponseEntity<>("Educational Details are deleted.", HttpStatus.OK);	
	}
}
