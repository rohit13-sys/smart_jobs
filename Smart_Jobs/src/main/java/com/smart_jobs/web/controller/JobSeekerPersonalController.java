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
@RequestMapping("api/v1/personal")
public class JobSeekerPersonalController {
	
//	@Autowired
//	private JobSeekerPersonalService jobSeekerPersonalService;
//	
//	@PostMapping("/savePersonalDetails")
//	public ResponseEntity<String> savePersonalDetails(
//			@RequestBody JobSeekerPersonalRequest jobSeekerPersonalRequest, 
//			Principal principal){
//		jobSeekerPersonalService.saveJobSeeker(jobSeekerPersonalRequest, principal);
//		return new ResponseEntity<>("Personal details are saved.", HttpStatus.OK);
//	}
//	
//	@GetMapping("/getPersonalDetails")
//	public JobSeekerPersonalResponse getPersonalDetails(Principal principal) {
//		return jobSeekerPersonalService.getJobSeeker(principal);	
//	}
//	
//	@PostMapping("/updatePersonalDetails")
//	public ResponseEntity<String> updatePersonalDetails(
//			@RequestBody JobSeekerPersonalRequest jobSeekerPersonalRequest, 
//			Principal principal){
//		jobSeekerPersonalService.updateJobSeeker(jobSeekerPersonalRequest, principal);
//		return new ResponseEntity<>("Personal details are updated.", HttpStatus.OK);
//	}
//	
//	@PostMapping("/deletePersonalDetails/{sr_no}")
//	public ResponseEntity<String> deletePersonalDetails(Long sr_no, Principal principal){
//		jobSeekerPersonalService.deleteJobSeeker(sr_no, principal);
//		return new ResponseEntity<>("Personal details are deleted.", HttpStatus.OK);
//	}
}
