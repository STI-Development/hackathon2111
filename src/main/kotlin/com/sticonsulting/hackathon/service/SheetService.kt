package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.entity.Sheet
import com.sticonsulting.hackathon.repository.SheetRepository
import org.springframework.stereotype.Service

@Service
class SheetService (private val sheetRepository: SheetRepository){

    fun createSheet(sheet: Sheet){
        sheetRepository.save(sheet)
    }

    fun getAllSheets(): List<Sheet> {
        return sheetRepository.findAll().toList()
    }

}