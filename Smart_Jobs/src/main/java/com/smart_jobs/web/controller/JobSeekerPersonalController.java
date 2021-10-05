package com.smart_jobs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smart_jobs.exceptions.JobActivityStatusNotFound;
import com.smart_jobs.exceptions.JobSeekerNotFound;
import com.smart_jobs.services.JobSeekerPersonalService;
import com.smart_jobs.web.model.JobSeekerPersonal;

/*
 * @author bhargav.parmar@stltech.in
 * @version 2.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 * @description Every api is working fine but there is no spring security
 * 				so better to use only one user so that explicitly ID 
 * 				is provided.
 */

@CrossOrigin
@RestController
@RequestMapping("api/v1/personal")
public class JobSeekerPersonalController {
	
	@Autowired
	private JobSeekerPersonalService jobSeekerPersonalService;

	@PostMapping("/savePersonalDetails")
	public ResponseEntity<String> savePersonalDetails(@RequestBody JobSeekerPersonal jobSeekerPersonalRequest) {
//		System.out.println("jos"+jobSeekerPersonalRequest);
		jobSeekerPersonalService.saveJobSeeker(jobSeekerPersonalRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}
//	
	@PostMapping("/getPersonalDetails/{email}")
	public JobSeekerPersonal getPersonalDetails(@PathVariable("email") String email) {
		JobSeekerPersonal js= jobSeekerPersonalService.getJobSeeker(email);
//		System.out.println(">>>>>>>>>>>>>>"+js);
		return js;
	}
//	
	@PostMapping("/updatePersonalDetails")
	public ResponseEntity<String> updatePersonalDetails(
			@RequestBody JobSeekerPersonal jobSeekerPersonalRequest){
		jobSeekerPersonalService.updateJobSeeker(jobSeekerPersonalRequest);
		return new ResponseEntity<>("Personal details are updated.", HttpStatus.OK);
	}
	
	@PostMapping("/deletePersonalDetails/{sr_no}")
	public ResponseEntity<String> deletePersonalDetails(@PathVariable Long sr_no){
		try {
			jobSeekerPersonalService.deleteJobSeeker(sr_no);
		} catch (JobActivityStatusNotFound | JobSeekerNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Sorry!!! JobSeeker Not found.", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>("Personal details are deleted.", HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("myFile") MultipartFile file,@RequestParam("jsId") String jSeekerId) {
		System.out.println("file");
		jobSeekerPersonalService.saveImage(file, jSeekerId); 
		
	}
}
