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

@Entity
@Table(name="job_activity_status")
public class Job_Activity_Status {

	
	@ManyToOne
	@JoinColumn(name = "jobseeker_email")
	@NotNull
	private JobSeeker_Personal jspersonal;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long jobStatusId;
	
	@ManyToOne
	@JoinColumn(name = "jobPost_id")
	@NotNull
	private JobPost jobPost;
	
	private Date apply_date;
	
	private Date rejected_date;
	
	private String job_status;
	
	public Job_Activity_Status() {
		// TODO Auto-generated constructor stub
	}

	public Job_Activity_Status(JobSeeker_Personal jspersonal, JobPost jobPost, Date apply_date, Date rejected_date,
			String job_status) {
		super();
		this.jspersonal = jspersonal;
		this.jobPost = jobPost;
		this.apply_date = apply_date;
		this.rejected_date = rejected_date;
		this.job_status = job_status;
	}

	public JobSeeker_Personal getJspersonal() {
		return jspersonal;
	}

	public void setJspersonal(JobSeeker_Personal jspersonal) {
		this.jspersonal = jspersonal;
	}

	public JobPost getJobPost() {
		return jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public Date getApply_date() {
		return apply_date;
	}

	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}

	public Date getRejected_date() {
		return rejected_date;
	}

	public void setRejected_date(Date rejected_date) {
		this.rejected_date = rejected_date;
	}

	public String getJob_status() {
		return job_status;
	}

	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}

	@Override
	public String toString() {
		return "Job_Activity_Status [jspersonal=" + jspersonal + ", jobPost=" + jobPost + ", apply_date=" + apply_date
				+ ", rejected_date=" + rejected_date + ", job_status=" + job_status + "]";
	}
	
	
}
