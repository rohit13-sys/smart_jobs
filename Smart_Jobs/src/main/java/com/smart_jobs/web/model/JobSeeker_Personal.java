package com.smart_jobs.web.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "JobSeeker_personal")
public class JobSeeker_Personal {

	@Id
	private Long sr_no;

	@ManyToOne
	@JoinColumn(name="jobSeeker_email")
	@NotNull
	private Login login;
	
	@NotNull
	private String seeker_name;

	@NotNull
	private int ph_no;
	
	private byte[] photo;
	
	private byte[] resume;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	@NotNull
	private Skills skills;


	public JobSeeker_Personal() {
		// TODO Auto-generated constructor stub
	}


	public JobSeeker_Personal(Long sr_no, Login login, String seeker_name, int ph_no, byte[] photo, byte[] resume,
			Skills skills) {
		super();
		this.sr_no = sr_no;
		this.login = login;
		this.seeker_name = seeker_name;
		this.ph_no = ph_no;
		this.photo = photo;
		this.resume = resume;
		this.skills = skills;
	}


	public Long getSr_no() {
		return sr_no;
	}


	public void setSr_no(Long sr_no) {
		this.sr_no = sr_no;
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


	public int getPh_no() {
		return ph_no;
	}


	public void setPh_no(int ph_no) {
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


	public Skills getSkills() {
		return skills;
	}


	public void setSkills(Skills skills) {
		this.skills = skills;
	}


	@Override
	public String toString() {
		return "JobSeeker_Personal [sr_no=" + sr_no + ", login=" + login + ", seeker_name=" + seeker_name + ", ph_no="
				+ ph_no + ", photo=" + Arrays.toString(photo) + ", resume=" + Arrays.toString(resume) + ", skills="
				+ skills + "]";
	}

		
	
}
