package com.smartjobs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartjobs.entities.JobPost;

/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description JobPost Repo.
 * 
 */
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

	List<JobPost> findAll();
	List<JobPost> findById(int id);
	List<JobPost> findByCompany(String comName);
	Optional<JobPost> findByIds(int id);
	Optional<JobPost> findByComapany(String comName);
	List<JobPost> findBySkills(String sid);
	Optional<JobPost> findBySkill(String sid);
	List<JobPost> findBySalary(float salary);
	List<JobPost> findBySalaryBetween(float minsalary,float maxsalary);
	List<JobPost> findBySkillsAndSalary(String sname,float salary);
	List<JobPost> findBySkillsAndCompany(String sname,String cname);
	 
}
