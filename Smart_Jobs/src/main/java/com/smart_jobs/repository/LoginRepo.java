package com.smart_jobs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobSeekerPersonal;
import com.smart_jobs.web.model.Login;


public interface LoginRepo extends JpaRepository<Login,String > {

	Login findByUserIdAndPwd(String un, String pwd);
	Login findByUserIdAndPwdAndRole(String un, String pwd,String role);
}
