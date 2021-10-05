package com.smart_jobs.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.services.EmployerService;
import com.smart_jobs.web.model.Employer;

/* @author parthkumar.panchal
 * @version 1.0
 * @creation_date 09-09-2021
 * @copyright sterlite technology Ltd.
 * @description Controller of Employer
 * */

@CrossOrigin
@RestController
@RequestMapping("/Employee")
public class EmployerController {

	private static final Logger LOGGER = LogManager.getLogger(EmployerController.class);

	@Autowired
	private EmployerService empService;

	@PostMapping("/registerEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employer emp) {
		try {
//			System.out.println(emp.getLogin().getUserId());
			LOGGER.debug(emp.getLogin().getUserId());
			empService.add(emp);
		} catch (EmployerAlreadyExists e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PostMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("eid") String empId, @RequestParam("pwd") String epassword) {
		try {
			return empService.delete(empId, epassword);
		} catch (EmployerNotFound e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employer employer) {
		try {
			empService.edit(employer);
		} catch (EmployerNotFound e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Employer updated Successfully";
	}

	@PostMapping("/getEmployee")
	public Employer getEmployee(@RequestParam("empId") String empId) {
		return empService.findEmployerByName(empId);
	}
}
