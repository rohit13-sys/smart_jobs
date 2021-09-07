package com.smart_jobs.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.service.login.LoginService;
import com.smart_jobs.web.model.Login;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Login login) {
		if(login!=null) {
			Optional<Login> lData=this.loginService.loginCheck(login.getUn(), login.getPwd());
			if(lData!=null){
				String role=lData.get().getRole();
				return new ResponseEntity<>("Role:"+role,HttpStatus.ACCEPTED); 
			}
			else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
				
		}	
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}}
