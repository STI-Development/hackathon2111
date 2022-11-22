package com.sticonsulting.hackathon.controller

import com.sticonsulting.hackathon.dto.JobApplicationDto
import com.sticonsulting.hackathon.service.JobApplicationService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class JobApplicationController(private val jobApplicationService: JobApplicationService) {
    @PostMapping("/apply")
    fun addJobApplication(@Validated @RequestBody jobApplicationDto: JobApplicationDto) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.addJobApplication(jobApplicationDto))
    }

    @GetMapping("/apply")
    fun getLatestJobApplication() : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.getJobApplication())
    }

    @GetMapping("/apply/{id}")
    fun getLatestJobApplication(@PathVariable(name = "id") id: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.getJobApplicationById(id))
    }
}