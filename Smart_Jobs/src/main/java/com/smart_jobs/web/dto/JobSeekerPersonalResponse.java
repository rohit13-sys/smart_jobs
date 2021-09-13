package com.smart_jobs.web.dto;

/*
 * @author bhargav.parmar@stltech.in
 * @version 1.0
 * @creation_date 09-Sept-2021
 * @copyright Sterlite Technologies Ltd.
 */

public class JobSeekerPersonalResponse {
	private String seeker_name;

	private int ph_no;
	
	private byte[] photo;
	
	private byte[] resume;

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
}
