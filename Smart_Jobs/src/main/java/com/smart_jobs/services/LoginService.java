package com.smart_jobs.services;

import java.util.List;

import com.smart_jobs.web.model.Login;

public interface LoginService {

	//Login loginCheck(String seekerUn, String seekerPWD);
	Login loginCheck1(String seekerUn, String seekerPWD,String role);
	Login getLogin(String email);
}
