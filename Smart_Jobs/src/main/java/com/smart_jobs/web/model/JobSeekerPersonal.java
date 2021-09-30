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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="JobSeeker_email")
	@NotNull
	private Login login;
	
	@NotNull
	private String seeker_name;

	@NotNull
	private BigInteger ph_no;
	
	private byte[] photo;
	
	private byte[] resume;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "sr_no")
//	@JoinColumn(name="skill_id")
	@NotNull
	private Set<JsSkills> skills;

	public JobSeekerPersonal() {
		super();
	}

	public JobSeekerPersonal(Long sr_no, Login login, String seeker_name, BigInteger ph_no, byte[] photo, byte[] resume,
			Set<JsSkills> skills) {
		super();
		this.srNo = sr_no;
		this.login = login;
		this.seeker_name = seeker_name;
		this.ph_no = ph_no;
		this.photo = photo;
		this.resume = resume;
		this.skills = skills;
	}

	public Long getSr_no() {
		return srNo;
	}

	public void setSr_no(Long sr_no) {
		this.srNo = sr_no;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getSeeker_name() {
		return seeker_name;
	}

	public void setSeeker_name(String seeker_name) {
		this.seeker_name = seeker_name;
	}

	public BigInteger getPh_no() {
		return ph_no;
	}

	public void setPh_no(BigInteger ph_no) {
		this.ph_no = ph_no;
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

	public Set<JsSkills> getSkills() {
		return skills;
	}

	public void setSkills(Set<JsSkills> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "JobSeekerPersonal [sr_no=" + srNo + ", login=" + login + ", seeker_name=" + seeker_name + ", ph_no="
				+ ph_no + ", photo=" + Arrays.toString(photo) + ", resume=" + Arrays.toString(resume) + ", skills="
				+ skills + "]";
	}
	
	

	
} // End of class
