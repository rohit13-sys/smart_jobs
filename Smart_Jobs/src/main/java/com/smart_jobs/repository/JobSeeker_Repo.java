package com.smart_jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_jobs.web.model.JobSeeker;

public interface JobSeeker_Repo extends JpaRepository<JobSeeker,Long> {

}
