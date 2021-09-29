package com.smart_jobs.services.login;

import java.util.List;
/* @author rohit.khatwanistltech.in
 * @version 1.0
 * @creation_date 10-09-2021
 * @copyright smart_jobs
 * 
 * */
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
		return login;
	}

	@Override
	public List<Login> getLogin() {
		List<Login> login=this.loginRepo.findAll();
		return login;
	}
	
	
	
	
}
