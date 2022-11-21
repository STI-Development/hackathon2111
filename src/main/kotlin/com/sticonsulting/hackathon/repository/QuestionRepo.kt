package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.entity.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepo : JpaRepository<Question,Long>