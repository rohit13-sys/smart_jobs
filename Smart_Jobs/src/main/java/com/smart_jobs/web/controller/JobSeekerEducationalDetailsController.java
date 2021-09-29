package com.smart_jobs.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

@RestController
@RequestMapping("api/v1/educational")
public class JobSeekerEducationalDetailsController {
	
//	@Autowired
//	private JobSeekerEducationalDetailsService jobSeekerEducationalDetailsService;
//	
//	@PostMapping("/saveEducationalDetails")
//	public ResponseEntity<String> saveEducationalDetails(
//			@RequestBody JobSeekerEducationalDetailRequest jobSeekerEducationalDetailRequest,
//			Principal principal){
//		jobSeekerEducationalDetailsService.saveEducationalDetails(jobSeekerEducationalDetailRequest, principal);
//		return new ResponseEntity<>("Educational Details are saved.", HttpStatus.OK);	
//	}
//	
//	@GetMapping("/getEducationalDetails")
//	public JobSeekerEducationalDetailsResponse getEducationalDetails(Principal principal){
//		return jobSeekerEducationalDetailsService.getEducationalDetails(principal);	
//	}
//	
//	@PostMapping("/updateEducationalDetails")
//	public ResponseEntity<String> updateEducationalDetails(
//			@RequestBody JobSeekerEducationalDetailRequest jobSeekerEducationalDetailRequest,
//			Principal principal){
//		return new ResponseEntity<>("Educational Details updated.", HttpStatus.OK);	
//	}
//	
//	@PostMapping("/deleteEducationalDetails/{education_id}")
//	public ResponseEntity<String> deleteEducationalDetails(@PathVariable Long education_id,Principal principal){
//		jobSeekerEducationalDetailsService.deleteEducationalDetails(education_id, principal);
//		return new ResponseEntity<>("Educational Details are deleted.", HttpStatus.OK);	
//	}
}
