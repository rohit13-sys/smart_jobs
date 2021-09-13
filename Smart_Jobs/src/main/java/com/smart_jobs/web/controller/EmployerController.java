package com.smart_jobs.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.service.employer.Employer_Service;
import com.smart_jobs.service.login.LoginService;
import com.smart_jobs.web.model.Employer;
import com.smart_jobs.web.model.Login;

@RestController
public class EmployerController {

//	@Autowired
//	Employer_Service empService;
//	
//	@Autowired
//	LoginService loginService;
//	
//	@PostMapping("/registerEmp")
//	public ResponseEntity<Object> registerEmp(@RequestBody Employer emp,Optional<Login> login){
//		login=this.loginService.loginCheck(emp.getLogin().getUn(),emp.getLogin().getPwd());
//		if(login.isEmpty()) {
//			this.empService.saveEmp(emp);
//			return new ResponseEntity<>("Employee"+emp,HttpStatus.CREATED);
//		}
//		else {
//			return new ResponseEntity<>("Employer already exist",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//	}
}
