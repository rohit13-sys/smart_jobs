package com.smart_jobs.services.login;

import java.util.List;

/* @author rohit.khatwanistltech.in
 * @version 1.0
 * @creation_date 10-09-2021
 * @copyright smart_jobs
 * 
 * */

import java.util.Optional;

import com.smart_jobs.web.model.Login;

public interface LoginService {

	Login loginCheck(String seekerUn, String seekerPWD);
	List<Login> getLogin();
	
}
