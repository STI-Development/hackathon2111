package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.JobApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface JobApplicationRepository : CrudRepository<JobApplication, Long>{
    fun findFirstByActiveIsTrueOrderByCreatedAtDesc() : Optional<JobApplication>
}