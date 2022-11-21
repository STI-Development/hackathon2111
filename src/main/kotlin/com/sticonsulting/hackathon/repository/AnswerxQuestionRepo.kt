package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.entity.AnswerxQuestion
import com.sticonsulting.hackathon.entity.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AnswerxQuestionRepo : JpaRepository<AnswerxQuestion,Long>{

//    @Query("SELECT b " +
//            "FROM answerxquestion a" +
//            "INNER JOIN a.answer b ")
//    fun findAllAnswersForQuestionJoin(): List<Answer>

    @Query("SELECT a.answer FROM AnswerxQuestion a where a.question = ?1")
    fun findAllAnswersForQuestion(questionid: Long): List<Long>

}