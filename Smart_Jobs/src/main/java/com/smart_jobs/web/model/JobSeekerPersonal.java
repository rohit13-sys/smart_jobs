package com.smart_jobs.web.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "JobSeeker_personal")
public class JobSeekerPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "increment")
	private Long srNo;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="JobSeeker_email")
	@NotNull
	private Login login;
	
	@NotNull
	private String seekerName;

	@NotNull		
	private BigInteger seekerMobile;	
	
	private byte[] photo;
	
	private byte[] resume;
	
	@NotNull
	private String gender;
	
	
	@OneToMany(mappedBy = "sr_no")
	@JsonManagedReference
//	@JoinColumn(name="skill_id")
	@NotNull
	private Set<JsSkills> skills;

	@OneToOne(mappedBy = "jsPersonalId")
	private JobSeekerEducationDetails jsEduId;
	
	@OneToOne(mappedBy = "jsPersonalId")
	private JobSeekerExperienceDetails jsExpId;
	
	public JobSeekerPersonal() {
		super();
	}

	public JobSeekerPersonal(Long srNo, Login login, String seekerName, BigInteger seekerMobile, byte[] photo,
			byte[] resume, String gender, Set<JsSkills> skills, JobSeekerEducationDetails jsEduId,
			JobSeekerExperienceDetails jsExpId) {
		super();
		this.srNo = srNo;
		this.login = login;
		this.seekerName = seekerName;
		this.seekerMobile = seekerMobile;
		this.photo = photo;
		this.resume = resume;
		this.gender = gender;
		this.skills = skills;
		this.jsEduId = jsEduId;
		this.jsExpId = jsExpId;
	}

	public Long getSrNo() {
		return srNo;
	}

	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getSeekerName() {
		return seekerName;
	}

	public void setSeekerName(String seekerName) {
		this.seekerName = seekerName;
	}

	public BigInteger getSeekerMobile() {
		return seekerMobile;
	}

	public void setSeekerMobile(BigInteger seekerMobile) {
		this.seekerMobile = seekerMobile;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<JsSkills> getSkills() {
		return skills;
	}

	public void setSkills(Set<JsSkills> skills) {
		this.skills = skills;
	}

	public JobSeekerEducationDetails getJsEduId() {
		return jsEduId;
	}

	public void setJsEduId(JobSeekerEducationDetails jsEduId) {
		this.jsEduId = jsEduId;
	}

	public JobSeekerExperienceDetails getJsExpId() {
		return jsExpId;
	}

	public void setJsExpId(JobSeekerExperienceDetails jsExpId) {
		this.jsExpId = jsExpId;
	}

	@Override
	public String toString() {
		return "JobSeekerPersonal [srNo=" + srNo + ", login=" + login + ", seekerName=" + seekerName + ", seekerMobile="
				+ seekerMobile + ", photo=" + Arrays.toString(photo) + ", resume=" + Arrays.toString(resume)
				+ ", gender=" + gender + ", skills=" + skills + ", jsEduId=" + jsEduId + ", jsExpId=" + jsExpId + "]";
	}
	
	
	

	
} // End of class
