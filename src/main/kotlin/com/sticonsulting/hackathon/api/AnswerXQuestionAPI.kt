package com.sticonsulting.hackathon.api

import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.service.QuestionFetcher
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController("/answerxquestion")
class AnswerXQuestionAPI(private val questionFetcher: QuestionFetcher) {

    @DeleteMapping(path = ["/{qid}/answer"])
    fun deleteAnswerConnection(@PathParam("qid") qid: Long, @RequestBody answer: Answer){

        return;
    }

    @DeleteMapping(path = ["/{qid}/answer/{aid}"])
    fun deleteAnswerToQuestionConnection(@PathParam("qid") qid: Long, @PathParam("aid") aid: Long){

        return;
    }

}