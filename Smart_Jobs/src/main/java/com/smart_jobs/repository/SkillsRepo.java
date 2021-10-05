package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Integer> {
	
	
}
