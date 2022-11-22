package com.sticonsulting.hackathon.api

import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.service.QuestionFetcher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController("/question")
class QuestionAPI(private val questionFetcher: QuestionFetcher) {

    @GetMapping(path = ["/{qid}/answers"])
    fun halloWelt(@PathParam("qid") qid: Long): List<Answer> {
        val allAnswersForQuestion = questionFetcher.getAllAnswersForQuestion(qid);
        return allAnswersForQuestion;
    }

}