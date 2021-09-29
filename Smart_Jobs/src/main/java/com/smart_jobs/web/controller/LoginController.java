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
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.services.login.LoginService;
import com.smart_jobs.web.model.Login;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login/employee")
	public ResponseEntity<Object> loginEmployee(@RequestBody Login login) {
		if (login != null) {
			Login lData = this.loginService.loginCheck(login.getUserId(), login.getPwd());
			System.out.println(">>>>>>>>>>>>>" + lData);
			System.out.println();
			if (lData != null) {
				String role = lData.getRole();
				return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
				// return role;
			} else {
				return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
				// return "not authorized";
			}
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			// return "error happened";
		}
	}
		
		@PostMapping("/login/seeker")
		public ResponseEntity<Object> loginSeeker(@RequestBody Login login) {
			if (login != null) {
				Login lData = this.loginService.loginCheck(login.getUserId(), login.getPwd());
				System.out.println(">>>>>>>>>>>>>" + lData);
				System.out.println();
				if (lData != null) {
					String role = lData.getRole();
					return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
					// return role;
				} else {
					return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
					// return "not authorized";
				}
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
				// return "error happened";
			}

	}

	@GetMapping("/getLogin")
	public List<Login> getLogin() {
		List<Login> login = this.loginService.getLogin();
		return login;
	}
}
