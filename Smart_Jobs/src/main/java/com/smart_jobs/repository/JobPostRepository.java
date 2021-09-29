package com.smart_jobs.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobPost;

/*
 * @author Mehul Thakor, bhargav.parmar@stltech.in
 * @version 2.0
 * @creation date 9-sept-2021, @update 28-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description JobPost Repo.
 * @update_description Changed type of findById to BigInteger because
 * 						of database.
 * 
 */
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

	List<JobPost> findAll();
	
	// changint ype to bigint due to database settings
	List<JobPost> findByJobPostId(Long i);
	
	//List<JobPost> findByCompany(String comName);
	//Optional<JobPost> findByIds(int id);
	//Optional<JobPost> findByComapany(String comName);
//	List<JobPost> findBySkills(String sid);
//	Optional<JobPost> findBySkill(String sid);
	List<JobPost> findBySalary(float salary);
	List<JobPost> findBySalaryBetween(float minsalary,float maxsalary);
//	List<JobPost> findBySkillsAndSalary(String sname,float salary);
//	List<JobPost> findBySkillsAndCompany(String sname,String cname);
	 
}
