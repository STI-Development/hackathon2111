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
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    @ManyToMany
    @JoinTable(name = "application_sheet",
        joinColumns = [JoinColumn(name = "application_id")],
        inverseJoinColumns = [JoinColumn(name = "sheet_id")]
    )
    val applicationSheets: Set<Sheet> = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as JobApplication

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , active = $active , createdAt = $createdAt )"
    }
}