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
@Table(name = "Jskills")
public class JsSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;

	@NotNull
	@Column(name = "skill_name")
	private String skillName;

//	@JsonBackReference
//	@NotNull
//	@ManyToOne
//	@JoinColumn(name = "job_post_id")
//	private JobPost jobPostId;
	
//	@ManyToOne
//	@JoinColumn(name = "user_email")
//	private Login login;
	
	
	@ManyToOne
	@JoinColumn(name = "js_id")
	@JsonBackReference
	private JobSeekerPersonal sr_no;
	public JsSkills() {
		// TODO Auto-generated constructor stub
	}
	

	public JsSkills(Long skillId, String skillName, JobSeekerPersonal sr_no) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.sr_no = sr_no;
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

	public JobSeekerPersonal getSr_no() {
		return sr_no;
	}

	public void setSr_no(JobSeekerPersonal sr_no) {
		this.sr_no = sr_no;
	}
	
	
	
}
