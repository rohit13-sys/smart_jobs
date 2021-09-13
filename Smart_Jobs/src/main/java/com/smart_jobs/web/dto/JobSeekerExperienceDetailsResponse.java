package com.smart_jobs.web.dto;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public class JobSeekerExperienceDetailsResponse {
	
	private String company_name;
	
	private boolean is_current_Active=false;
	
	private double year_of_exp;
	
	private String job_title;
	
	private String description;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public boolean getIs_current_Active() {
		return is_current_Active;
	}

	public void setIs_current_Active(boolean is_current_Active) {
		this.is_current_Active = is_current_Active;
	}

	public double getYear_of_exp() {
		return year_of_exp;
	}

	public void setYear_of_exp(double year_of_exp) {
		this.year_of_exp = year_of_exp;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
