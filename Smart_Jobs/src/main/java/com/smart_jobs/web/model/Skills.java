package com.smart_jobs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skill_id;

	@NotNull
	private String skill_name;

	@ManyToOne
	@JoinColumn(name = "user_email")
	private Login login;

	public Skills() {
		// TODO Auto-generated constructor stub
	}

	public Skills(Long skill_id, String skill_name, Login login) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
		this.login = login;
	}

	public Long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Skills [skill_id=" + skill_id + ", skill_name=" + skill_name + ", login=" + login + "]";
	}

}
