package com.smartjobs.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartjobs.entities.JobActivityStatus;
/*
 * @author Mehul Thakor
 * @version 1.0
 * @creation date 9-sept-2021
 * @copyright Smart Jobs Ltd.
 * @description Job Activity status Repo.
 * 
 */
public interface JobActivityRepository extends JpaRepository<JobActivityStatus, Integer> {

	List<JobActivityStatus> findById(int id);
	List<JobActivityStatus> findByJobPost(int id);
	List<JobActivityStatus> findByJobStatus(String status);
			
}
