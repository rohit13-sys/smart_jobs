package com.smart_jobs.web.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * 
 * */

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@Column(name = "company_name",length = 50)
	private String companyName;

	@NotNull	
	@Column(name = "establishment_date")
	private LocalDate establishmentDate;

	@OneToMany(mappedBy = "company")
	@NotNull
	//@JoinColumn(name = "employer_no")
	private List<Employer> employerNo;

	@Column(name = "company_website",length = 50)
	private String companyWebsite;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String companyName, LocalDate establishmentDate, String companyWebsite) {
		super();
		this.companyName = companyName;
		this.establishmentDate = establishmentDate;
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDate getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(LocalDate establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", establishmentDate=" + establishmentDate + ", companyWebsite="
				+ companyWebsite + "]";
	}

	
	

	
}

