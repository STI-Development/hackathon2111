package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.dto.JobApplicationDto
import com.sticonsulting.hackathon.entity.JobApplication
import com.sticonsulting.hackathon.repository.JobApplicationRepository
import org.springframework.stereotype.Service

@Service
class JobApplicationService(private val jobApplicationRepository: JobApplicationRepository) {
    fun addJobApplication(jobApplicationDto: JobApplicationDto) : JobApplicationDto{
        return entityToDto(jobApplicationRepository.save(dtoToEntity(jobApplicationDto)))
    }

    fun getJobApplication() : JobApplicationDto{
        return entityToDto(jobApplicationRepository.findFirstByActiveIsTrueOrderByCreatedAtDesc().orElseThrow())
    }

    fun getJobApplicationById(id: String) : JobApplicationDto{
        return entityToDto(jobApplicationRepository.findById(id.toLong()).orElseThrow())
    }

    private fun entityToDto(jobApplication: JobApplication) : JobApplicationDto{
        return JobApplicationDto(
            jobApplication.id,
            jobApplication.name,
            jobApplication.active
        )
    }

    private fun dtoToEntity(jobApplicationDto: JobApplicationDto) : JobApplication{
        return JobApplication(
            name = jobApplicationDto.name,
            active = jobApplicationDto.active
        )
    }
}