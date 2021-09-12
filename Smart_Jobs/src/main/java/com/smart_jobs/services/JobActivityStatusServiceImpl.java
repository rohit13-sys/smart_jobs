package com.smart_jobs.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.JobActivityStatusNotFound;
import com.smart_jobs.repository.JobActivityRepository;
import com.smart_jobs.web.model.JobActivityStatus;
/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description services for job activity status
 * 
 */
@Service
public class JobActivityStatusServiceImpl implements JobActivityStatusService {

	@Autowired
	private JobActivityRepository activityRepo;
	
	JobActivityStatus statusObj = new JobActivityStatus();
	
	public List<JobActivityStatus> findActivityStatus(int id) throws JobActivityStatusNotFound{
		return activityRepo.findById(id);
	}
	
	public List<JobActivityStatus> findStatusByJobId(int jid) throws JobActivityStatusNotFound{
		return activityRepo.findByJobPost(jid);
	}

	public List<JobActivityStatus> findActivityStatusByStatus(String astatus) throws JobActivityStatusNotFound{
		return activityRepo.findByJobStatus(astatus);
	}
	
	//create job activity status for user
	public String addActivityStatus(JobActivityStatus activity) {
	activity = activityRepo.save(activity);
	return "Job activity status " + activity.getJobStatusId() + " is added successfully";
	}
	
	//Update job activity status for user
	public String updateActivityStatus(String status) {
	statusObj.setJobStatus(status);
	return "Job activity status " + statusObj.getJobStatusId() + " is updated successfully";
	}
	
	//Add reject date for rejected user
	public String AddRejectDate(Date date) {
	statusObj.setRejectedDate(date);
	return "Reject date for " + statusObj.getJobStatusId() + " is added successfully";
}
}
