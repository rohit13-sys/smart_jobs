package com.smart_jobs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_jobs.exceptions.EmployerAlreadyExists;
import com.smart_jobs.exceptions.EmployerNotFound;
import com.smart_jobs.services.employer.EmployerService;
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

	@Autowired
	private EmployerService empService;

	@PostMapping("/registerEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employer emp) {
		try {
			// System.out.println(emp.getLogin().getUserId());
			this.empService.add(emp);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		} catch (EmployerAlreadyExists e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/deleteEmployee")
	public ResponseEntity<Object> deleteEmployee(@RequestParam("eid") String empId,
			@RequestParam("pwd") String epassword) {
		try {
			this.empService.delete(empId, epassword);
			return new ResponseEntity<Object>("Employer " + empId + " deleted successfully", HttpStatus.OK);
		} catch (EmployerNotFound e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/updateEmployee")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employer employer) {
		try {
			this.empService.edit(employer);
			return new ResponseEntity<Object>("Employer " + employer.getLogin().getUserId() + " updated successfully",
					HttpStatus.OK);
		} catch (EmployerNotFound e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEmployee")
	public Employer getEmployee(@RequestParam("empId") String empId) {
		return empService.findEmployerByName(empId);
	}
}
