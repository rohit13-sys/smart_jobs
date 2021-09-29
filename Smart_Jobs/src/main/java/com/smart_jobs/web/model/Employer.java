package com.smart_jobs.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * 
 * */

@Entity
@Table(name = "Employer_reg")
public class Employer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "increment")
	@Column(name = "employer_no")
	private Long employerNo;

	@OneToOne(cascade = {CascadeType.ALL})
	@NotNull
	@JoinColumn(name = "employer_email")
	private Login login;
	
	@NotNull
	@Column(name = "employer_name",length = 50)
	private String employerName;

	@NotNull
	@Column(name = "phone_no")
	private String phoneNo;

	@NotNull
	@Column(name = "branch_office_id")	
	private Long branchOfficeId;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "company_id")
	private Company company;

	public Employer() {
		// TODO Auto-generated constructor stub
	}

	public Employer(Long employerNo, Login login, String employerName, String phoneNo, Long branchOfficeId,
			Company company) {
		super();
		this.employerNo = employerNo;
		this.login = login;
		this.employerName = employerName;
		this.phoneNo = phoneNo;
		this.branchOfficeId = branchOfficeId;
		this.company = company;
	}

	public Long getEmployerNo() {
		return employerNo;
	}

	public void setEmployerNo(Long employerNo) {
		this.employerNo = employerNo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getBranchOfficeId() {
		return branchOfficeId;
	}

	public void setBranchOfficeId(Long branchOfficeId) {
		this.branchOfficeId = branchOfficeId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employer [employerNo=" + employerNo + ", login=" + login + ", employerName=" + employerName
				+ ", phoneNo=" + phoneNo + ", branchOfficeId=" + branchOfficeId + ", company=" + company + "]";
	}

	
	
}
