package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.Sheet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SheetRepository : CrudRepository <Sheet, Long>


