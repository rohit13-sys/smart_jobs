package com.smart_jobs.service.login;

import java.util.Optional;

import com.smart_jobs.web.model.Login;

public interface LoginService {

	Optional<Login> loginCheck(String seekerUn, String seekerPWD);
	
}
