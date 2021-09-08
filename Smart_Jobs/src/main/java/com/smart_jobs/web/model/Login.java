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
	@Column(name="user_email")
	private String user_id;
	
	@NotNull
	private String pwd;

	@NotNull
	private String role;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String user_id, String pwd, String role) {
		super();
		this.user_id = user_id;
		this.pwd = pwd;
		this.role = role;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "Login [user_id=" + user_id + ", pwd=" + pwd + ", role=" + role + "]";
	}

		
}
