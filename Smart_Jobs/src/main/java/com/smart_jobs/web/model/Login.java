package com.smart_jobs.web.model;

/* @author rohit.khatwanistltech.in
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright smart_jobs
 * 
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Login")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long lid;
	
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
