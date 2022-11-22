package com.sticonsulting.hackathon.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SheetDto(
    var id: Long?,
    @field:NotBlank(message = "name is not allowed to be empty")
    @field:Size(min = 3, max = 20, message = "Name should be between 3 - 20")
    var name: String,
    var text: String,
    var active: Boolean,
    var jobApplications: Set<JobApplicationDto> = HashSet()
)