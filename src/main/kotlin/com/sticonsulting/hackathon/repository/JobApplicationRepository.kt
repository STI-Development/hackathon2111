package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.JobApplication
import com.sticonsulting.hackathon.entity.Sheet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface JobApplicationRepository : CrudRepository<JobApplication, Long>{
    fun findFirstByActiveIsTrueOrderByCreatedAtDesc() : Optional<JobApplication>

    fun findByName(name: String): Optional<JobApplication>

    //fun findJobApplicationByIdAndApplicationSheetsAndId(id: Long, sheets: Set<Sheet>, sheetId: Long) : Optional<JobApplication>
}