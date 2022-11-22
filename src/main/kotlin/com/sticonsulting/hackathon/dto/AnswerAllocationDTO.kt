package com.sticonsulting.hackathon.dto

import com.sticonsulting.hackathon.entity.Answer
import javax.persistence.Column

data class AnswerAllocationDTO (

    val type: String,
    val text: String,
    val correct : Boolean,

)