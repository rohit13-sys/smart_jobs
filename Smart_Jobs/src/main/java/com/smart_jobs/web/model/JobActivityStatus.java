package com.smart_jobs.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description This is an entity to add activity status for jobseeker
 * 
 */

@Entity
@Table(name="jobActivityStatus")
public class JobActivityStatus {

	
	@ManyToOne
	@JoinColumn(name = "jobseekerEmail")
	@NotNull
	private JobSeeker_Personal jspersonal;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long jobStatusId;
	
	@ManyToOne
	@JoinColumn(name = "jobPostId")
	@NotNull
	private JobPost jobPost;
	
	private Date applyDate;
	
	private Date rejectedDate;
	
	private String jobStatus;
	
	public JobActivityStatus() {
		// TODO Auto-generated constructor stub
	}

	public JobActivityStatus(JobSeeker_Personal jspersonal, Long jobStatusId, JobPost jobPost, Date applyDate,
			Date rejectedDate, String jobStatus) {
		super();
		this.jspersonal = jspersonal;
		this.jobStatusId = jobStatusId;
		this.jobPost = jobPost;
		this.applyDate = applyDate;
		this.rejectedDate = rejectedDate;
		this.jobStatus = jobStatus;
	}

	public JobSeeker_Personal getJspersonal() {
		return jspersonal;
	}

	public void setJspersonal(JobSeeker_Personal jspersonal) {
		this.jspersonal = jspersonal;
	}

	public Long getJobStatusId() {
		return jobStatusId;
	}

	public void setJobStatusId(Long jobStatusId) {
		this.jobStatusId = jobStatusId;
	}

	public JobPost getJobPost() {
		return jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getRejectedDate() {
		return rejectedDate;
	}

	public void setRejectedDate(Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	@Override
	public String toString() {
		return "JobActivityStatus [jspersonal=" + jspersonal + ", jobStatusId=" + jobStatusId + ", jobPost=" + jobPost
				+ ", applyDate=" + applyDate + ", rejectedDate=" + rejectedDate + ", jobStatus=" + jobStatus + "]";
	}
	
}
