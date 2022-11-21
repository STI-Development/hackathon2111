package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*

@Entity
@Table(
    name = "answerxquestion",
)
data class AnswerxQuestion(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,

    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    var answer: Answer,

    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    var question: Question,

    @Column(name = "correct", nullable = false) var correct: Boolean,

    @CreationTimestamp
    @Column(updatable = false)
    val created: Instant? = Instant.now()
)

