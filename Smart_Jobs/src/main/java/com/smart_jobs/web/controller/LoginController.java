package com.smart_jobs.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.services.LoginService;
import com.smart_jobs.web.model.Login;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
//	
//	@PostMapping("/login/seeker")
//	public ResponseEntity<Object> login(@RequestBody Login login) {
//		if(login!=null) {
//			Login lData=this.loginService.loginCheck(login.getUserId(), login.getPwd());
//			if(lData!=null){
//				String role=lData.getRole();
//				return new ResponseEntity<Object>(HttpStatus.ACCEPTED); 
//			}
//			else {
//				return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
//			}
//				
//		}	
//		else {
//			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login1(@RequestBody Login login) {
		if(login!=null) {
			System.out.println("Login : " + login);
			Login lData = loginService.getLogin(login.getUserId());
			if(lData == null) {
				return new ResponseEntity<Object>(HttpStatus.CONFLICT);
			}
			lData=this.loginService.loginCheck1(login.getUserId(), login.getPwd() ,login.getRole());
			if(lData!=null){
				String role=lData.getRole();
				System.out.println("Yes");
				return new ResponseEntity<Object>(HttpStatus.ACCEPTED); 
			}
			else {
				System.out.println("No");
				return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
			}
				
		}	
		else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getLogin")
	public Login getLogin(@RequestParam("emailId") String email){
		Login login = loginService.getLogin(email);
		return login;
	}
}
