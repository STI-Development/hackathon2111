package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepo : JpaRepository<Answer,Long>