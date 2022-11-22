package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name="question")
data class Question (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Long?,

    @Column(name="text")
    val text: String,

    @Column(name="score")
    val score: Integer,

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false)
    val createdAt: Instant?
)