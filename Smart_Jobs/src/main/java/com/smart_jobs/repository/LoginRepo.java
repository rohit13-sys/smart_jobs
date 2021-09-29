package com.smart_jobs.repository;

/* @author rohit.khatwanistltech.in
 * @version 1.0
 * @creation_date 10-09-2021
 * @copyright smart_jobs
 * 
 * */

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobSeeker_Personal;
import com.smart_jobs.web.model.Login;


public interface LoginRepo extends JpaRepository<Login,Long > {

	Login findByUserIdAndPwd(String un, String pwd);
}
