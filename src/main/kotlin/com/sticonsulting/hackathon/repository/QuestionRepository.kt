package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.Question
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : CrudRepository <Question, Long>