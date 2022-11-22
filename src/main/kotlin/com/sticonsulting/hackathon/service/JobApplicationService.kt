package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.dto.JobApplicationDto
import com.sticonsulting.hackathon.dto.SheetDto
import com.sticonsulting.hackathon.entity.JobApplication
import com.sticonsulting.hackathon.entity.Sheet
import com.sticonsulting.hackathon.repository.JobApplicationRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityExistsException
import kotlin.jvm.Throws

@Service
class JobApplicationService(private val jobApplicationRepository: JobApplicationRepository, private val sheetService: SheetService) {

    @Throws(EntityExistsException::class)
    fun addJobApplication(jobApplicationDto: JobApplicationDto) : JobApplicationDto{
        val jobApplication = jobApplicationRepository.findByName(jobApplicationDto.name)
        if (jobApplication.isEmpty){
            return entityToDto(jobApplicationRepository.save(dtoToEntity(jobApplicationDto)))
        }
        throw EntityExistsException("Job Application with the name '" + jobApplicationDto.name + "' already exists")
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

    fun addSheetByIdToJobApplicationById(id: String, sheetId: String) : JobApplicationDto{
        val jobApplication = jobApplicationRepository.findById(id.toLong()).orElseThrow()
        val sheet = sheetService.getSheetById(sheetId.toLong()).orElseThrow()
        jobApplication.applicationSheets.add(sheet)
        return entityToDto(jobApplicationRepository.save(jobApplication))
    }

    fun getAllSheetsByJobApplication(id: String) : MutableSet<SheetDto>{
        val jobApplication = jobApplicationRepository.findById(id.toLong())
        val sheets = mutableSetOf<SheetDto>()
        for (i in jobApplication.orElseThrow().applicationSheets){
            sheets.add(sheetEntityToDto(i))
        }
        return sheets
    }

    @Throws(NoSuchElementException::class)
    fun getSheetByJobApplicationId(id: String, sheetId: String) : SheetDto{
        val jobApplication = jobApplicationRepository.findById(id.toLong())
        for(i in jobApplication.orElseThrow().applicationSheets){
            if (i.id == sheetId.toLong()){
                return sheetEntityToDto(i)
            }
        }
        throw NoSuchElementException("Application with the ID " + id + "does not have a sheet with the ID " + sheetId)
    }

    @Throws(NoSuchElementException::class)
    fun updateSheetInJobApplication(id: String, sheetDto: SheetDto, sheetId: String) : JobApplicationDto{
        val jobApplication = jobApplicationRepository.findById(id.toLong()).orElseThrow()
        val sheets = jobApplication.applicationSheets
        var sheetFound = false
        for(i in sheets){
            if (i.id == sheetId.toLong()){
                i.name = sheetDto.name
                i.text = sheetDto.text
                sheetFound = true
            }
        }
        if (sheetFound){
            return entityToDto(jobApplicationRepository.save(jobApplication))
        }
        throw NoSuchElementException("Application with the ID " + id + "does not have a sheet with the ID " + sheetId)
    }

    fun deleteJobApplication(id: String){
        jobApplicationRepository.deleteById(id.toLong())
    }

    fun deleteSheetFromJobApplication(id: String, sheetId: String){
        val jobApplication = jobApplicationRepository.findById(id.toLong()).orElseThrow()
        jobApplication.applicationSheets.removeIf { sheet -> sheet.id == sheetId.toLong() }
        jobApplicationRepository.save(jobApplication)
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