package com.smartjobs.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smartjobs.entities.JobActivityStatus;
import com.smartjobs.exceptions.JobActivityStatusNotFound;
import com.smartjobs.services.JobActivityStatusService;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description RESTful web service for job activity status
 * 
 */

@RequestMapping("/activitystatus")
@RestController
public class JobActivityStatusController {

	@Autowired
	private JobActivityStatusService activityService;
	
	JobActivityStatus statusObj = new JobActivityStatus();
	
	@GetMapping
	public List<JobActivityStatus> getActivityStatus(@RequestParam("id") int id) throws JobActivityStatusNotFound{
		return activityService.findActivityStatus(id);
	}
	
	@GetMapping("/jobid")
	public List<JobActivityStatus> getStatusByJobId(@RequestParam("jid") int jid) throws JobActivityStatusNotFound{
		return activityService.findStatusByJobId(jid);
	}
	
	@GetMapping("/jobstatus")
	public List<JobActivityStatus> getActivityStatusByStatus(@RequestParam("astatus") String astatus) throws JobActivityStatusNotFound{
		return activityService.findActivityStatusByStatus(astatus);
	}
	
	//create job activity status for user
	@PutMapping
	public void addActivityStatus(@RequestBody JobActivityStatus activity) {
	activityService.addActivityStatus(activity);
	}
	
	//Update job activity status for user
	@PutMapping("/updatestatus")
	public void updateActivityStatus(@RequestParam("status") String status) {
	activityService.updateActivityStatus(status);
	}
	
	//Add reject date for rejected user
	@PutMapping("/updatedate")
	public void AddRejectDate(@RequestParam("date") Date date) {
	activityService.AddRejectDate(date);
}
}