package com.smart_jobs.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Login")
public class Login {

	@Id
	@Column(name="user_email",length = 50)
	private String userId;
	
	@NotNull
	private String pwd;

	@NotNull
	private String role;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String userId, String pwd, String role) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "Login [userId=" + userId + ", pwd=" + pwd + ", role=" + role + "]";
	}

	
		
}
