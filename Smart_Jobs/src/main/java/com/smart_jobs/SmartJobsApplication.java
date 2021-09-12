package com.smart_jobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SmartJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartJobsApplication.class, args);
	}

}
