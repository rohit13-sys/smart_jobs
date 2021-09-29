package com.smart_jobs.repository;

/* @author rohit.khatwanistltech.in
 * @version 1.0
 * @creation_date 10-09-2021
 * @copyright smart_jobs
 * 
 * */

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Integer> {

}
