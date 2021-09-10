package com.smart_jobs.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.service.jobseeker.JobSeeker_Service;
import com.smart_jobs.service.login.LoginService;
import com.smart_jobs.web.model.JobSeeker_Personal;
import com.smart_jobs.web.model.Login;

@RestController
public class JobSeeker_Controller {

//	@Autowired
//	private JobSeeker_Service jsService;
//
//	@Autowired
//	private LoginService loginService;
//
//	//private PasswordEncoder passwordEncoder;
//
////	public JobSeeker_Controller() {
////		this.passwordEncoder = new BCryptPasswordEncoder();
////	}
//	
//	@PostMapping("/registerJS")
//	public ResponseEntity<Object> jobSRegister(@RequestBody JobSeeker_Personal js,Optional<Login> login) {
//		login=this.loginService.loginCheck(js.getLogin().getUn(),js.getLogin().getPwd());
//		if(login.isEmpty()) {
//			this.jsService.saveJS(js);
//			return new ResponseEntity<>(js,HttpStatus.CREATED);
//		}
//		else {
//			return new ResponseEntity<>("Jobseeker already exist",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
}
