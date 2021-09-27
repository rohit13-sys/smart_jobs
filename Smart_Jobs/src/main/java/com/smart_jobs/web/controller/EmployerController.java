package com.smart_jobs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Autowired
	private EmployerService empService;
	
	@PostMapping("/registerEmployee")
	public String addEmployee(@RequestBody Employer emp) {
		try {
			System.out.println(emp.getLogin().getUserId());
			empService.add(emp);
		} catch (EmployerAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return "Product Added Successfully";
	}
	
	@PostMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("eid") String empId,@RequestParam("pwd") String epassword) {
		try {
				return empService.delete(empId, epassword);
		} catch (EmployerNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employer employer) {
		try {
				empService.edit(employer);
		} catch (EmployerNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return "Product updated Successfully";
	}
	
	@GetMapping("/getEmployee")
	public Employer getEmployee(@RequestParam("empId") String empId) {
		return empService.findEmployerByName(empId);
	}
}
