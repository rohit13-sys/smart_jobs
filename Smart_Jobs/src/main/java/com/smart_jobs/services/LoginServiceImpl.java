package com.smart_jobs.services;

import java.util.List;
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
	public Login loginCheck(String un, String pwd) {
		Login login=loginRepo.findByUserIdAndPwd(un, pwd);
		System.out.println(login);
		return login;
	}

	@Override
	public List<Login> getLogin() {
		// TODO Auto-generated method stub
		List<Login> login = loginRepo.findAll();
		return login;
	}
	
	
}
