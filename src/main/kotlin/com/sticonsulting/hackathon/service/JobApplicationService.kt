package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.dto.JobApplicationDto
import com.sticonsulting.hackathon.dto.SheetDto
import com.sticonsulting.hackathon.entity.JobApplication
import com.sticonsulting.hackathon.entity.Sheet
import com.sticonsulting.hackathon.repository.JobApplicationRepository
import org.springframework.stereotype.Service

@Service
class JobApplicationService(private val jobApplicationRepository: JobApplicationRepository, private val sheetService: SheetService) {
    fun addJobApplication(jobApplicationDto: JobApplicationDto) : JobApplicationDto{
        return entityToDto(jobApplicationRepository.save(dtoToEntity(jobApplicationDto)))
    }

    fun getJobApplication() : JobApplicationDto{
        return entityToDto(jobApplicationRepository.findFirstByActiveIsTrueOrderByCreatedAtDesc().orElseThrow())
    }

    fun getJobApplicationById(id: String) : JobApplicationDto{
        return entityToDto(jobApplicationRepository.findById(id.toLong()).orElseThrow())
    }

    fun addSheetToJobApplicationById(id: String, sheetDto: SheetDto) : JobApplicationDto{
        val jobApplication = jobApplicationRepository.findById(id.toLong())
        jobApplication.orElseThrow().applicationSheets.add(sheetDtoToEntity(sheetDto))
        return entityToDto(jobApplicationRepository.save(jobApplication.get()))
    }

    private fun entityToDto(jobApplication: JobApplication) : JobApplicationDto{
        val applicationSheets: MutableSet<SheetDto> = mutableSetOf()
        for (i in jobApplication.applicationSheets){
            applicationSheets.add(sheetEntityToDto(i))
        }
        return JobApplicationDto(
            id = jobApplication.id,
            name = jobApplication.name,
            active = jobApplication.active,
            applicationSheets = applicationSheets
        )
    }

    private fun dtoToEntity(jobApplicationDto: JobApplicationDto) : JobApplication{
        val applicationSheets: MutableSet<Sheet> = mutableSetOf()
        for (i in jobApplicationDto.applicationSheets){
            applicationSheets.add(sheetDtoToEntity(i))
        }
        return JobApplication(
            name = jobApplicationDto.name,
            active = jobApplicationDto.active,
            applicationSheets = applicationSheets
        )
    }

    private fun sheetDtoToEntity(sheetDto: SheetDto) : Sheet{
        return Sheet(
            sheetDto.id,
            sheetDto.name,
            sheetDto.text,

        )
    }

    private fun sheetEntityToDto(sheet: Sheet) : SheetDto{
        return SheetDto(
            sheet.id,
            sheet.name,
            sheet.text
        )
    }
}