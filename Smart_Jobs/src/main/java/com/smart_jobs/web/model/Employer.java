package com.smart_jobs.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Employer_reg")
public class Employer {

	@Id
	private Long employer_no;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "employer_email")
	private Login login;
	
	@NotNull
	private String employer_name;

	@NotNull
	private int ph_No;

	@NotNull
	private Long branch_office_id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "company_id")
	private Company company;

	public Employer() {
		// TODO Auto-generated constructor stub
	}

	public Employer(Long employer_no, Login login, String employer_name, int ph_No, Long branch_office_id,
			Company company) {
		super();
		this.employer_no = employer_no;
		this.login = login;
		this.employer_name = employer_name;
		this.ph_No = ph_No;
		this.branch_office_id = branch_office_id;
		this.company = company;
	}

	public Long getEmployer_no() {
		return employer_no;
	}

	public void setEmployer_no(Long employer_no) {
		this.employer_no = employer_no;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}

	public int getPh_No() {
		return ph_No;
	}

	public void setPh_No(int ph_No) {
		this.ph_No = ph_No;
	}

	public Long getBranch_office_id() {
		return branch_office_id;
	}

	public void setBranch_office_id(Long branch_office_id) {
		this.branch_office_id = branch_office_id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employer [employer_no=" + employer_no + ", login=" + login + ", employer_name=" + employer_name
				+ ", ph_No=" + ph_No + ", branch_office_id=" + branch_office_id + ", company=" + company + "]";
	}

	
}
