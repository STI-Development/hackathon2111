package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*

@Entity
@Table(
    name = "answer",
)
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "type", nullable = false) var type: String,

    @Column(name = "text", nullable = false) var text: String,


    @CreationTimestamp
    @Column(updatable = false)
    val created: Instant? = Instant.now()
)

