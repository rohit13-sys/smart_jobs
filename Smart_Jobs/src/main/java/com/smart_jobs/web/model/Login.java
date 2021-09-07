package com.smart_jobs.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LoginId")
	private Long loginId;

	private String un;

	private String pwd;

	private String role;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(Long loginId, String un, String pwd, String role) {
		super();
		this.loginId = loginId;
		this.un = un;
		this.pwd = pwd;
		this.role = role;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", un=" + un + ", pwd=" + pwd + ", role=" + role + "]";
	} 

	
	
	
	
}
