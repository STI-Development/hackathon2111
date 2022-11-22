package com.sticonsulting.hackathon.api

import com.sticonsulting.hackathon.dto.AnswerAllocationDTO
import com.sticonsulting.hackathon.entity.Answer
import com.sticonsulting.hackathon.service.AnswerUpdater
import com.sticonsulting.hackathon.service.QuestionFetcher
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController("/answer")
class AnswerAPI(private val questionFetcher: QuestionFetcher, private val answerService: AnswerUpdater) {

    @PostMapping(path = ["/{qid}/answer"])
    fun saveAnswer(@PathVariable("qid") qid: Long, @RequestBody answer: AnswerAllocationDTO ){
        var response = answerService.createAnswer(Answer(null,answer.type,answer.text), qid, answer.correct);
        return;
    }

    @PostMapping(path = ["/{qid}/answer/{aid}"])
    fun saveAnswerToQuestion(@PathParam("qid") qid: Long, @PathParam("aid") aid: Long){

        return;
    }

    @PatchMapping(path = ["/{qid}/answer/{aid}"])
    fun changeAnswer(@PathParam("qid") qid: Long, @RequestBody answer: Answer){

        return;
    }

}