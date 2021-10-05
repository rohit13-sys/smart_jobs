package com.smart_jobs.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.exceptions.JobPostNotFound;
import com.smart_jobs.repository.EmployerRepository;
import com.smart_jobs.repository.JobActivityRepository;
import com.smart_jobs.repository.JobPostRepository;
import com.smart_jobs.repository.SkillsRepo;
import com.smart_jobs.web.model.JobActivityStatus;
import com.smart_jobs.web.model.JobPost;
import com.smart_jobs.web.model.Skills;

/*
 * @author Mehul Thakor,Parthkumar Panchal,Rohit Khatwani
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description services for job post
 * 
 */
@Service
public class JobPostServiceImpl implements JobPostService {

	private static final Logger LOGGER = LogManager.getLogger(JobPostServiceImpl.class);

	@Autowired
	private JobPostRepository jobPostRepo;

	@Autowired
	private SkillsRepo skillsRepo;

	@Autowired
	private EmployerRepository employerRepo;

	@Autowired
	private JobActivityRepository jsActRepo;

	public List<JobPost> findAllJobs() throws JobPostNotFound {
		return jobPostRepo.findAll();
	}

	public JobPost findJobById(long id) throws JobPostNotFound {
		Optional<JobPost> op = jobPostRepo.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			LOGGER.error("Sorry Job Post not found");
			throw new JobPostNotFound("Sorry Job Post not found");
		}

	}

//	public List<JobPost> findJobByCompany(String cname) throws JobPostNotFound{
//		return jobPostRepo.findByCompany(cname);
//	}
//	
//	public List<JobPost> findJobBySkills(String skills) throws JobPostNotFound{
//		return jobPostRepo.findBySkills(skills);
//	}

	public List<JobPost> findJobBySalary(float salary) throws JobPostNotFound {
		return jobPostRepo.findBySalary(salary);
	}

	public List<JobPost> findJobBySalaryInRange(float minsalary, float maxsalary) throws JobPostNotFound {
		return jobPostRepo.findBySalaryBetween(minsalary, maxsalary);
	}

//	public List<JobPost> findJobBySkillsAndSalary(String sname,float salary) throws JobPostNotFound{
//		return jobPostRepo.findBySkillsAndSalary(sname,salary);
//	}
//
//	public List<JobPost> findJobBySkillsAndCompany(String sname,String cname) throws JobPostNotFound{
//		return jobPostRepo.findBySkillsAndCompany(sname,cname);
//	}

	@Override
	public String addJob(JobPost job) {
		job.setEmployee(employerRepo.findByLogin_UserId(job.getEmployee().getLogin().getUserId()).get());
		Set<Skills> skills = job.getSkills();
		job.setActive(true);
		job.setPostedDate(LocalDate.now());
		job = jobPostRepo.save(job);
//		System.out.println(skills);
		LOGGER.debug("Skills: " + skills);
		for (Skills skill : skills) {
			System.out.println(skill);
			skill.setJobPostId(job);
			skill.setLogin(job.getEmployee().getLogin());
			skillsRepo.save(skill);
		}
		LOGGER.debug("Job is posted.");
		return "Job " + job.getJobPostId() + " is posted successfully";
	}

//	
	@Override
	public String deleteJob(long id) throws JobPostNotFound {
		Optional<JobPost> op = jobPostRepo.findById(id);
		if (op.isPresent()) {
			JobPost job = op.get();
//				System.out.println("jobs"+job);
			LOGGER.debug("jobs" + job);
			List<JobActivityStatus> jobas = jsActRepo.findByJobPost_JobPostId(job.getJobPostId());
//				System.out.println(jobas);
			LOGGER.debug(jobas);
			if (!jobas.isEmpty()) {
				for (JobActivityStatus jobact : jobas) {
					jsActRepo.delete(jobact);
					LOGGER.debug("Job Activity status Deleted.");
				}
			}
			for (Skills skill : job.getSkills()) {
				skillsRepo.delete(skill);
			}

			jobPostRepo.delete(job);
			LOGGER.debug("Job Deleted.");
			return "job " + job.getJobPostId() + " deleted successfully";
		} else {
			LOGGER.error("sorry! Job is not found");
			return "sorry! Job is not found";
		}
	}

//	@Override
//	public JobPost findJobById(int id) throws JobPostNotFound {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public String deleteJobBySkills(Optional<JobPost> jb,JobPost job,String skills) throws JobPostNotFound{
//		jb = jobPostRepo.findBySkill(skills);
//		if(jb.isPresent()) {
//			 job = jb.get();
//			 jobPostRepo.delete(job);
//			 return "Job for " + job.getSkills() + " is deleted successfully";}
//		else {
//			return "Product not found";
//		}
//			
//	}
//	
//	public String deleteJobByCompany(Optional<JobPost> jb,JobPost job,String cname) throws JobPostNotFound{
//		jb = jobPostRepo.findByComapany(cname);
//		if(jb.isPresent()) {
//			 job = jb.get();
//			 jobPostRepo.delete(job);
//			 return "Job for " + job.getCompany() + " is deleted successfully";}
//		else {
//			return "Product not found";
//		}
//	}
	@Override
	public String updateJob(JobPost job) {
		Optional<JobPost> op = jobPostRepo.findById(job.getJobPostId());
		if (op.isPresent()) {
			JobPost Njob = op.get();
			job.setEmployee(Njob.getEmployee());
			Set<Skills> skills = Njob.getSkills();
			for (Skills skill : skills) {
				skillsRepo.delete(skill);
			}
			skills = job.getSkills();
			for (Skills skill : skills)
				skill.setSkillId(null);
			job = jobPostRepo.save(job);
//			System.out.println("skillls" + skills);
			LOGGER.debug("Skillls" + skills);
			for (Skills skill : skills) {
				skill.setJobPostId(job);
				skill.setLogin(job.getEmployee().getLogin());
//				System.out.println("skill :::::" + skill);
				LOGGER.debug("skill :::::" + skill);
				skillsRepo.save(skill);
				LOGGER.debug("Skillls saved successfully");
			}
			LOGGER.debug("Job is updated.");
			return "Job " + job.getJobPostId() + " is updated successfully";
		} else {
			LOGGER.error("Job is not found.");
			return "sorry! job is not found";
		}
	}

	@Override
	public List<JobPost> findJobPostByEmail(String email) throws JobPostNotFound {
		return jobPostRepo.findByEmployee_login_userId(email);
	}
}
