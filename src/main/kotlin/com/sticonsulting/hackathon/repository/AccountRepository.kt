package com.sticonsulting.hackathon.repository

import com.sticonsulting.hackathon.entity.TestEntity
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<TestEntity, Long>