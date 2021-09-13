package com.smart_jobs.web.dto;

import java.util.Date;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public class JobSeekerEducationalDetailsResponse {
	
	private double HSC_result;

	private double SSC_result;
	
	private String university_name;

	private Date start_date;

	private Date end_date;

	private double percentage;

	private double cgpa;

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
}
