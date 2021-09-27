package com.smart_jobs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobSeeker_Personal;
import com.smart_jobs.web.model.Login;


public interface LoginRepo extends JpaRepository<Login,Long > {

	Login findByUserIdAndPwd(String un, String pwd);
}
