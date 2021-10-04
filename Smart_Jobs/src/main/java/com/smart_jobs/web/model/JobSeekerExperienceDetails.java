package com.smart_jobs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="exp_details")
public class JobSeekerExperienceDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long exp_id;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_email")
	@NotNull
	private Login login;
	
	private String companyName;
	
	private double yearOfExp;
	
	private String jobTitle;
	
	private String description;
	
	public JobSeekerExperienceDetails() {
		// TODO Auto-generated constructor stub
	}

	public JobSeekerExperienceDetails(Long exp_id, Login login, String companyName, double yearOfExp, String jobTitle,
			String description) {
		super();
		this.exp_id = exp_id;
		this.login = login;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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
		return "JobSeekerExperienceDetails [exp_id=" + exp_id + ", login=" + login + ", companyName=" + companyName
				+ ", yearOfExp=" + yearOfExp + ", jobTitle=" + jobTitle + ", description=" + description + "]";
	}

	
		
} // End of class
