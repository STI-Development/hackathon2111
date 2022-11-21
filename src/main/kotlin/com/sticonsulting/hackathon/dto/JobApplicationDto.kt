package com.sticonsulting.hackathon.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class JobApplicationDto(
    var id: Long?,
    @NotBlank(message = "name is not allowed to be empty")
    @Size(min = 3, max = 20, message = "Name should be between 3 - 20")
    var name: String,
    var active: Boolean
)
