package com.sticonsulting.hackathon.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name="sheet")
data class Sheet (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        val id: Long?,

        @Column(name="name")
        val name: String,

        @Column(name="text")
        val text: String,

        @CreationTimestamp
        @Column(name = "createdAt", updatable = false)
        val createdAt: Instant? = Instant.now(),

        @ManyToMany(mappedBy = "applicationSheets")
        val jobApplications: Set<JobApplication> = HashSet()
)