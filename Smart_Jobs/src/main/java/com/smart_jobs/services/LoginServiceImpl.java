package com.smart_jobs.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.Login;

@Service
public class LoginServiceImpl implements LoginService{
	
	private static final Logger LOGGER = LogManager.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginRepo loginRepo;

//	@Override
//	public Login loginCheck(String un, String pwd) {
//		Login login=loginRepo.findByUserIdAndPwd(un, pwd);
//		System.out.println(login);
//		return login;
//	}
	
	@Override
	public Login loginCheck1(String un, String pwd,String role) {
		Login login=loginRepo.findByUserIdAndPwdAndRole(un, pwd,role);
//		System.out.println(login);
		LOGGER.debug(login);
		return login;
	}

	@Override
	public Login getLogin(String email) {
		Optional<Login> login = loginRepo.findById(email);
		if(login.isPresent()) {
			LOGGER.debug(login);
			return login.get();
		}
		LOGGER.error("Can not found login info.");
		return null;
	}
}
