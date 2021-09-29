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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;

	@NotNull
	@Column(name = "skill_name")
	private String skillName;

	@JsonBackReference
	@NotNull
	@ManyToOne
	@JoinColumn(name = "job_post_id")
	private JobPost jobPostId;
	
	@ManyToOne
	@JoinColumn(name = "user_email")
	private Login login;

	public Skills() {
		// TODO Auto-generated constructor stub
	}

	public Skills(Long skillId, String skillName, Login login) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.login = login;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public JobPost getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(JobPost jobPostId) {
		this.jobPostId = jobPostId;
	}

	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + ", login=" + login + "]";
	}

	
}
