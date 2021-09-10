package com.smartjobs.entities;

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
public class JsExp_Details {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long exp_id;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_email")
	@NotNull
	private Login Login;
	
	private String company_name;
	
	private boolean is_current_Active=false;
	
	private double year_of_exp;
	
	private String job_title;
	
	private String description;
	
	public JsExp_Details() {
		// TODO Auto-generated constructor stub
	}

	public JsExp_Details(Long exp_id, com.smartjobs.entities.Login login, String company_name,
			boolean is_current_Active, double year_of_exp, String job_title, String description) {
		super();
		this.exp_id = exp_id;
		Login = login;
		this.company_name = company_name;
		this.is_current_Active = is_current_Active;
		this.year_of_exp = year_of_exp;
		this.job_title = job_title;
		this.description = description;
	}

	public Long getExp_id() {
		return exp_id;
	}

	public void setExp_id(Long exp_id) {
		this.exp_id = exp_id;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login login) {
		Login = login;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public boolean isIs_current_Active() {
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

	@Override
	public String toString() {
		return "JsExp_Details [exp_id=" + exp_id + ", Login=" + Login + ", company_name=" + company_name
				+ ", is_current_Active=" + is_current_Active + ", year_of_exp=" + year_of_exp + ", job_title="
				+ job_title + ", description=" + description + "]";
	}

	
}
