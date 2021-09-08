package com.smart_jobs.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	private String company_name;

	@NotNull
	private Date establishment_date;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "employer_id")
	private Login login;

	private String company_website;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String company_name, Date establishment_date, Login login, String company_website) {
		super();
		this.company_name = company_name;
		this.establishment_date = establishment_date;
		this.login = login;
		this.company_website = company_website;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Date getEstablishment_date() {
		return establishment_date;
	}

	public void setEstablishment_date(Date establishment_date) {
		this.establishment_date = establishment_date;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getCompany_website() {
		return company_website;
	}

	public void setCompany_website(String company_website) {
		this.company_website = company_website;
	}

	@Override
	public String toString() {
		return "Company [company_name=" + company_name + ", establishment_date=" + establishment_date + ", login="
				+ login + ", company_website=" + company_website + "]";
	}

	
}

