package com.smart_jobs.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "job_post")
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long job_post_id;

	@NotNull
	private String job_type;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skills skills;

	private int vacancies;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@NotNull
	private double salary_stipend;

	@ManyToOne
	@JoinColumn(name = "company_name")
	private Company company;

	@NotNull
	private String office_address;

	private Date posted_date;

	@NotNull
	private boolean is_active = false;

	public JobPost() {
		// TODO Auto-generated constructor stub
	}

	public JobPost(Long job_post_id, String job_type, Skills skills, int vacancies, Employer employer,
			double salary_stipend, Company company, String office_address, Date posted_date, boolean is_active) {
		super();
		this.job_post_id = job_post_id;
		this.job_type = job_type;
		this.skills = skills;
		this.vacancies = vacancies;
		this.employer = employer;
		this.salary_stipend = salary_stipend;
		this.company = company;
		this.office_address = office_address;
		this.posted_date = posted_date;
		this.is_active = is_active;
	}

	public Long getJob_post_id() {
		return job_post_id;
	}

	public void setJob_post_id(Long job_post_id) {
		this.job_post_id = job_post_id;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
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

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public double getSalary_stipend() {
		return salary_stipend;
	}

	public void setSalary_stipend(double salary_stipend) {
		this.salary_stipend = salary_stipend;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getOffice_address() {
		return office_address;
	}

	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}

	public Date getPosted_date() {
		return posted_date;
	}

	public void setPosted_date(Date posted_date) {
		this.posted_date = posted_date;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public String toString() {
		return "JobPost [job_post_id=" + job_post_id + ", job_type=" + job_type + ", vacancies=" + vacancies
				+ ", employer=" + employer + ", salary_stipend=" + salary_stipend + ", company=" + company
				+ ", office_address=" + office_address + ", posted_date=" + posted_date + ", is_active=" + is_active
				+ "]";
	}

}
