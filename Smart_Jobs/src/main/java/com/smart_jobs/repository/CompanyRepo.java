package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.Company;

public interface CompanyRepo extends JpaRepository<Company, String> {

}
