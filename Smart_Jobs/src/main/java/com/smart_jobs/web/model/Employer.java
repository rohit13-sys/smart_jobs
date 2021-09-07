package com.smart_jobs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "EmployerReg")
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employerId;

	private String employerFn;

	private String employerLn;

	@ManyToOne
	@JoinColumn(name = "login_id")
	@Cascade(CascadeType.ALL)
	private Login login;

	public Employer() {
		// TODO Auto-generated constructor stub
	}

	public Employer(Long employerId, String employerFn, String employerLn, Login login) {
		super();
		this.employerId = employerId;
		this.employerFn = employerFn;
		this.employerLn = employerLn;
		this.login = login;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployerFn() {
		return employerFn;
	}

	public void setEmployerFn(String employerFn) {
		this.employerFn = employerFn;
	}

	public String getEmployerLn() {
		return employerLn;
	}

	public void setEmployerLn(String employerLn) {
		this.employerLn = employerLn;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", employerFn=" + employerFn + ", employerLn=" + employerLn
				+ ", login=" + login + "]";
	}
	
	
}
