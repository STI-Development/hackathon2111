package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(
    name = "accountv2",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["email"])
    ]
)
data class TestEntity(
    @Id
    val id: Long,

    @Column(name = "email", nullable = false)
    var email: String,

    @CreationTimestamp
    @Column(updatable = false)
    val created: Instant? = Instant.now(),
)
