package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobSeeker_Personal;

public interface JobSeeker_Repo extends JpaRepository<JobSeeker_Personal,Long> {

}
