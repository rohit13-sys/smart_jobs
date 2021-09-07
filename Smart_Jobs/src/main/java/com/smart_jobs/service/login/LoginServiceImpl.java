package com.smart_jobs.service.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_jobs.repository.LoginRepo;
import com.smart_jobs.web.model.Login;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepo loginRepo;

	@Override
	public Optional<Login> loginCheck(String un, String pwd) {
		Optional<Login> login=loginRepo.findByUnAndPwd(un, pwd);
		return login;
	}
	
	
}
