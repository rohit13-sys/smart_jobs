package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.Login;


public interface LoginRepo extends JpaRepository<Login,Long> {
	public Login findByEmail(String email);
}
