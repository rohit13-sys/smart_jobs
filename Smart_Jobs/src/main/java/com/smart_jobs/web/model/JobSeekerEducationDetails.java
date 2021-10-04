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
@Table(name = "education_details")
public class JobSeekerEducationDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long education_id;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_email")
	@NotNull
	private Login login;

	private String hscResult;

	private String sscResult;

	@NotNull
	private String universityName;

	private String startDate;

	private String endDate;

	private double percentage;

	private double cgpa;

	public JobSeekerEducationDetails() {
		// TODO Auto-generated constructor stub
	}

	public JobSeekerEducationDetails(Long education_id, Login login, String hscResult, String sscResult,
			String universityName, String startDate, String endDate, double percentage, double cgpa) {
		super();
		this.education_id = education_id;
		this.login = login;
		this.hscResult = hscResult;
		this.sscResult = sscResult;
		this.universityName = universityName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.percentage = percentage;
		this.cgpa = cgpa;
	}

	public Long getEducation_id() {
		return education_id;
	}

	public void setEducation_id(Long education_id) {
		this.education_id = education_id;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getHscResult() {
		return hscResult;
	}

	public void setHscResult(String hscResult) {
		this.hscResult = hscResult;
	}

	public String getSscResult() {
		return sscResult;
	}

	public void setSscResult(String sscResult) {
		this.sscResult = sscResult;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "JobSeekerEducationDetails [education_id=" + education_id + ", login=" + login + ", hscResult="
				+ hscResult + ", sscResult=" + sscResult + ", universityName=" + universityName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", percentage=" + percentage + ", cgpa=" + cgpa + "]";
	}

		
	
} // End of class
