package com.smart_jobs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.exceptions.AlreadyApplied;
import com.smart_jobs.exceptions.JobActivityStatusNotFound;
import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.repository.JobActivityRepository;
import com.smart_jobs.services.JobActivityStatusService;
import com.smart_jobs.services.JobSeekerPersonalService;
import com.smart_jobs.web.model.JobActivityStatus;
import com.smart_jobs.web.model.JobPost;
import com.smart_jobs.web.model.JobSeekerPersonal;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class JobActivityStatusController {

	@Autowired
	private JobActivityStatusService activityStatus;
	
	@Autowired
	private JobActivityRepository activityRepo;
	
	@Autowired
	private JobSeekerPersonalService jsService;

	@PostMapping("/applyJob")
	public ResponseEntity<String> applyJob(@RequestBody JobActivityStatus applyingJobRequest) {
		try {
			activityStatus.applyJobs(applyingJobRequest);
		} catch (AlreadyApplied e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/deleteJob/{jobActId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobActId") Long jpId) {
		try {
			activityStatus.deleteActivityStatus(jpId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (JobActivityStatusNotFound e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
	}
	
	
	@GetMapping("/getAppliedJobs")
	public List<JobPost> findAppliedJobs() throws JobPostNotFound {
		return activityStatus.findAppliedJobs();
	}
	
	@PostMapping("/find")
	public JobActivityStatus findjob(@RequestParam("jbid") Long jbId,@RequestParam("jsid") Long jsId) {
		return activityRepo.findByJobPost_JobPostIdAndJspersonal_SrNo(jbId, jsId);
	}

	@PostMapping("/findJobSeeker")
	public List<JobSeekerPersonal> findjobSeeker(@RequestParam("jbid") Long jbId) {
		return jsService.findJsByJpId(jbId);
	}
	
	@GetMapping("/getAppliedJobs/{id}")
	public List<JobActivityStatus> findAppliedJobs(@PathVariable("id") String id) throws JobPostNotFound {
		return activityRepo.findAppliedJobsByJspersonal_Login_UserId(id);
	}
}
