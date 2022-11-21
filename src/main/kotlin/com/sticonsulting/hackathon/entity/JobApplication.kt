package com.sticonsulting.hackathon.entity
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "job_application")
data class JobApplication(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    val name: String,
    val active: Boolean = true,
    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime? = LocalDateTime.now()
)