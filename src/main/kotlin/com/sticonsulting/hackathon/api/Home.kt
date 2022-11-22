package com.sticonsulting.hackathon.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Home {

    @GetMapping(path= arrayOf("/"))
    fun home(): String{
        return "you are home";
    }
}