package com.smart_jobs.web.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description This is an entity for Posting jobs 
 * 
 */

@Entity
@Table(name = "jobPost")
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "increment")
	private Long jobPostId;

	@NotNull
	private String jobType;
	
	@NotNull
	private String jobRole;

	@OneToMany(mappedBy = "jobPostId"	)
	@JsonManagedReference
	//@JoinColumn(name = "skillId")
	private Set<Skills> skills;

	
	private int vacancies;

	@ManyToOne
	@JoinColumn(name = "employerId")
	private Employer employee;

	@NotNull
	private double salary;

//	@ManyToOne
//	@JoinColumn(name = "company_name")
//	private Company company;

	@NotNull
	private String officeAddress;

	@NotNull
	private LocalDate postedDate;

	@NotNull
	private boolean isActive = false;
	
	@NotNull
	private String experience;

	public JobPost() {
		// TODO Auto-generated constructor stub
	}

	public JobPost(Long jobPostId, String jobType, String jobRole, Set<Skills> skills, int vacancies, Employer employee,
			double salary, String officeAddress, LocalDate postedDate, boolean isActive, String experience) {
		super();
		this.jobPostId = jobPostId;
		this.jobType = jobType;
		this.jobRole = jobRole;
		this.skills = skills;
		this.vacancies = vacancies;
		this.employee = employee;
		this.salary = salary;
		this.officeAddress = officeAddress;
		this.postedDate = postedDate;
		this.isActive = isActive;
		this.experience = experience;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public Employer getEmployee() {
		return employee;
	}

	public void setEmployee(Employer employee) {
		this.employee = employee;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "JobPost [jobPostId=" + jobPostId + ", jobType=" + jobType + ", jobRole=" + jobRole + ", skills="
				+ skills + ", vacancies=" + vacancies + ", employee=" + employee + ", salary=" + salary
				+ ", officeAddress=" + officeAddress + ", postedDate=" + postedDate + ", isActive=" + isActive
				+ ", experience=" + experience + "]";
	}

	

}
