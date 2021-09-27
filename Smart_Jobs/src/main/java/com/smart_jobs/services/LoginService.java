package com.smart_jobs.services;

import java.util.List;

import com.smart_jobs.web.model.Login;

public interface LoginService {

	Login loginCheck(String seekerUn, String seekerPWD);
	List<Login> getLogin();
}
