package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*

@Entity
@Table(
    name = "question",
)
data class Question(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,

    @Column(name = "text", nullable = false) var type: String,

    @Column(name = "score") var email: Int,

    @CreationTimestamp
    @Column(updatable = false)
    val created: Instant? = Instant.now()
)

