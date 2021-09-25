package com.smartjobs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	@GeneratedValue(generator="increment")
	private int jobPostId;

	@NotNull
	private String jobType;

	@ManyToOne
	@JoinColumn(name = "skillId")
	private Skills skills;

	private int vacancies;

	@ManyToOne
	@JoinColumn(name = "employerId")
	private Employer employee;

	@NotNull
	private double salary;

	@ManyToOne
	@JoinColumn(name = "company_name")
	private Company company;

	@NotNull
	private String officeAddress;

	private Date postedDate;

	@NotNull
	private boolean isActive = false;

	public JobPost() {
		// TODO Auto-generated constructor stub
	}

	public JobPost(int jobPostId, String jobType, Skills skills, int vacancies, Employer employee, double salary,
			Company company, String officeAddress, Date postedDate, boolean isActive) {
		super();
		this.jobPostId = jobPostId;
		this.jobType = jobType;
		this.skills = skills;
		this.vacancies = vacancies;
		this.employee = employee;
		this.salary = salary;
		this.company = company;
		this.officeAddress = officeAddress;
		this.postedDate = postedDate;
		this.isActive = isActive;
	}



	public int getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(int jobPostId) {
		this.jobPostId = jobPostId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "JobPost [jobPostId=" + jobPostId + ", jobType=" + jobType + ", skills=" + skills + ", vacancies="
				+ vacancies + ", employee=" + employee + ", salary=" + salary + ", company=" + company
				+ ", officeAddress=" + officeAddress + ", postedDate=" + postedDate + ", isActive=" + isActive + "]";
	}

}
