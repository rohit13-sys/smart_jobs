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

	private double HSC_result;

	private double SSC_result;

	@NotNull
	private String university_name;

	private Date start_date;

	private Date end_date;

	private double percentage;

	private double cgpa;

	public JobSeekerEducationDetails() {
		// TODO Auto-generated constructor stub
	}

	public JobSeekerEducationDetails(Long education_id, Login login, double hSC_result, double sSC_result,
			String university_name, Date start_date, Date end_date, double percentage, double cgpa) {
		super();
		this.education_id = education_id;
		this.login = login;
		HSC_result = hSC_result;
		SSC_result = sSC_result;
		this.university_name = university_name;
		this.start_date = start_date;
		this.end_date = end_date;
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

	public double getHSC_result() {
		return HSC_result;
	}

	public void setHSC_result(double hSC_result) {
		HSC_result = hSC_result;
	}

	public double getSSC_result() {
		return SSC_result;
	}

	public void setSSC_result(double sSC_result) {
		SSC_result = sSC_result;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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
		return "JsEducation_details [education_id=" + education_id + ", login=" + login + ", HSC_result=" + HSC_result
				+ ", SSC_result=" + SSC_result + ", university_name=" + university_name + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", percentage=" + percentage + ", cgpa=" + cgpa + "]";
	}
} // End of class
