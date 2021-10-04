package com.smart_jobs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="exp_details")
public class JobSeekerExperienceDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long exp_id;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "jobseeker_email")
	@NotNull
	private JobSeekerPersonal jsPersonalId;
	
	private String companyName;
	
	private double yearOfExp;
	
	private String jobTitle;
	
	private String description;
	
	public JobSeekerExperienceDetails() {
		// TODO Auto-generated constructor stub
	}

	public JobSeekerExperienceDetails(Long exp_id, JobSeekerPersonal jsPersonalId, String companyName, double yearOfExp,
			String jobTitle, String description) {
		super();
		this.exp_id = exp_id;
		this.jsPersonalId = jsPersonalId;
		this.companyName = companyName;
		this.yearOfExp = yearOfExp;
		this.jobTitle = jobTitle;
		this.description = description;
	}

	public Long getExp_id() {
		return exp_id;
	}

	public void setExp_id(Long exp_id) {
		this.exp_id = exp_id;
	}

	public JobSeekerPersonal getJsPersonalId() {
		return jsPersonalId;
	}

	public void setJsPersonalId(JobSeekerPersonal jsPersonalId) {
		this.jsPersonalId = jsPersonalId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getYearOfExp() {
		return yearOfExp;
	}

	public void setYearOfExp(double yearOfExp) {
		this.yearOfExp = yearOfExp;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "JobSeekerExperienceDetails [exp_id=" + exp_id + ", jsPersonalId=" + jsPersonalId + ", companyName="
				+ companyName + ", yearOfExp=" + yearOfExp + ", jobTitle=" + jobTitle + ", description=" + description
				+ "]";
	}

	
	
		
} // End of class
