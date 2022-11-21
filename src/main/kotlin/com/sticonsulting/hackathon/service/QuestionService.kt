package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.entity.Question
import com.sticonsulting.hackathon.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService (private val questionRepository: QuestionRepository){

    fun createQuestion(question : Question){
        questionRepository.save(question)
       }

    fun getAllQuestions(): List<Question> {
        return questionRepository.findAll().toList();
    }
}