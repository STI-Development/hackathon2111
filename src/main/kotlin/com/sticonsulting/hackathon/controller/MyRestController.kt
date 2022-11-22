package com.sticonsulting.hackathon.controller

import com.sticonsulting.hackathon.entity.Question
import com.sticonsulting.hackathon.entity.Sheet
import com.sticonsulting.hackathon.service.QuestionService
import com.sticonsulting.hackathon.service.SheetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MyRestController(private val questionService: QuestionService,
                        private val sheetService: SheetService ) {

    @GetMapping("/test")
    fun test(): String {return "es funktioniert!"}

    @PostMapping("/questions")
    fun createQuestion(@RequestBody question: Question){
        questionService.createQuestion(question)
    }

    @GetMapping("/questions")
    fun getAllQuestions(): List<Question>{
        return questionService.getAllQuestions()
    }


    @PostMapping("/sheets")
    fun createSheet(@RequestBody sheet: Sheet){
        sheetService.createSheet(sheet)
    }

    @GetMapping("/sheets")
    fun getAllSheets(): List<Sheet>{
        return sheetService.getAllSheets()
    }




}