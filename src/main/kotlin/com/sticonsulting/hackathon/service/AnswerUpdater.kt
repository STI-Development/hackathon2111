package com.sticonsulting.hackathon.service

import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.entity.AnswerxQuestion
import com.sticonsulting.hackathon.entity.Question
import com.sticonsulting.hackathon.repository.AnswerRepo
import com.sticonsulting.hackathon.repository.AnswerxQuestionRepo
import com.sticonsulting.hackathon.repository.QuestionRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
//class QuestionFetcher(private val answerxQuestionRepo: AnswerxQuestionRepo) {
class AnswerUpdater @Autowired constructor(
    private val answerxQuestionRepo: AnswerxQuestionRepo,
    private val questionRepo: QuestionRepo,
    private val answerRepo: AnswerRepo)
{

    fun createAnswer(answer: Answer, qid:Long, isCorrect : Boolean): Answer{

        answerRepo.save(answer);
        val q = Question(100,"testtype", "teStmail");
        val save = questionRepo.save(q);

        var newAxQ = AnswerxQuestion(answer = answer, question = questionRepo.findById(save.id).get(), correct = isCorrect);


        answerxQuestionRepo.save(newAxQ);

        return answer;

    }


}