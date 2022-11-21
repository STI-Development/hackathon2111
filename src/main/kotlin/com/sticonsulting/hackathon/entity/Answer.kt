package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*

@Entity
@Table(
    name = "answer",
)
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,

    @Column(name = "type", nullable = false) var type: String,

    @Column(name = "email", nullable = false, length = 255) var email: String,

    @CreationTimestamp
    @Column(updatable = false)
    val created: Instant? = Instant.now()
)

