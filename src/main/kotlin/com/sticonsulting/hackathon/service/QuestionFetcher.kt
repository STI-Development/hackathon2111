package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.entity.Question
import com.sticonsulting.hackathon.repository.AnswerRepo
import com.sticonsulting.hackathon.repository.AnswerxQuestionRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
//class QuestionFetcher(private val answerxQuestionRepo: AnswerxQuestionRepo) {
class QuestionFetcher @Autowired constructor(
    private val answerxQuestionRepo: AnswerxQuestionRepo,
    private val answerRepo: AnswerRepo
) {

    fun getAllAnswersForQuestion(question: Question): List<Answer> {
        return getAllAnswersForQuestion(question.id);
    }

//    fun getAllAnswersForQuestion(id: Long): List<Answer> {
////        return answerxQuestionRepo.findAllAnswersForQuestion(id);
//        return answerxQuestionRepo.findAllAnswersForQuestionJoin()
//    }

    fun getAllAnswersForQuestion(id: Long): List<Answer> {
//        return answerxQuestionRepo.findAllAnswersForQuestion(id);
        val findAllAnswersForQuestion: List<Long> =
            answerxQuestionRepo.findAllAnswersForQuestion(id)
        val listeAnAntworten = arrayListOf<Answer>()
        for (index in findAllAnswersForQuestion) {
            listeAnAntworten.add(answerRepo.findById(index).get())
        }
        return listeAnAntworten;
    }
}