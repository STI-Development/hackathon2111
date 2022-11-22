package com.sticonsulting.hackathon.controller

import com.sticonsulting.hackathon.dto.JobApplicationDto
import com.sticonsulting.hackathon.dto.SheetDto
import com.sticonsulting.hackathon.service.JobApplicationService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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

    @GetMapping("/apply/{id}/sheet")
    fun getAllSheetsByJobApplication(@PathVariable(name = "id") id: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.getAllSheetsByJobApplication(id))
    }

    @GetMapping("/apply/{id}/sheet/{sheetId}")
    fun getSheetByJobApplicationId(@PathVariable(name = "id") id: String, @PathVariable(name = "sheetId") sheetId: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.getSheetByJobApplicationId(id, sheetId))
    }

    @PostMapping("/apply/{id}/sheet")
    fun addSheetToJobApplication(@PathVariable(name = "id") id: String, @Validated @RequestBody sheetDto: SheetDto) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.addSheetToJobApplicationById(id, sheetDto))
    }

    @PostMapping("/apply/{id}/sheet/{sheetId}")
    fun addSheetByIdToJobApplication(@PathVariable(name = "id") id: String, @PathVariable(name = "sheetId") sheetId: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.addSheetByIdToJobApplicationById(id, sheetId))
    }
    @PatchMapping("/apply/{id}/sheet/{sheetId}")
    fun updateSheetInJobApplication(@PathVariable(name = "id") id: String, @Validated @RequestBody sheetDto: SheetDto, @PathVariable(name = "sheetId") sheetId: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.updateSheetInJobApplication(id, sheetDto , sheetId))
    }

    @GetMapping("/apply")
    fun getLatestJobApplication() : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.getJobApplication())
    }

    @GetMapping("/apply/{id}")
    fun getLatestJobApplication(@PathVariable(name = "id") id: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.getJobApplicationById(id))
    }

    @DeleteMapping("/apply/{id}")
    fun deleteJobApplication(@PathVariable(name = "id") id: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.deleteJobApplication(id))
    }

    @DeleteMapping("/apply/{id}/sheet/{sheetId}")
    fun deleteSheetFromJobApplication(@PathVariable(name = "id") id: String, @PathVariable(name = "sheetId") sheetId: String) : ResponseEntity<Any>{
        return ResponseEntity.ok(jobApplicationService.deleteSheetFromJobApplication(id, sheetId))
    }
}