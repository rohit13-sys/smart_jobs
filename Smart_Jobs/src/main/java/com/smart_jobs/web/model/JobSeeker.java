package com.smart_jobs.web.model;

import javax.persistence.Column;
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
@Table(name = "JobSeeker_Reg")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seekerId")
	private Long seekerId;

	private String seekerFn;

	private String seekerLn;

	@ManyToOne
	@JoinColumn(name = "login_id")
	@Cascade(CascadeType.ALL)
	private Login login;

	public JobSeeker() {
		// TODO Auto-generated constructor stub
	}

	public JobSeeker(Long seekerId, String seekerFn, String seekerLn, Login login) {
		super();
		this.seekerId = seekerId;
		this.seekerFn = seekerFn;
		this.seekerLn = seekerLn;
		this.login = login;
	}

	public Long getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(Long seekerId) {
		this.seekerId = seekerId;
	}

	public String getSeekerFn() {
		return seekerFn;
	}

	public void setSeekerFn(String seekerFn) {
		this.seekerFn = seekerFn;
	}

	public String getSeekerLn() {
		return seekerLn;
	}

	public void setSeekerLn(String seekerLn) {
		this.seekerLn = seekerLn;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "JobSeeker [seekerId=" + seekerId + ", seekerFn=" + seekerFn + ", seekerLn=" + seekerLn + ", login="
				+ login + "]";
	}
	
	

	
}
