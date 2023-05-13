package com.example.demo.springsecurity21.repository

import com.example.demo.springsecurity21.model.SiteUser
import org.springframework.data.jpa.repository.JpaRepository

interface SiteUserRepository: JpaRepository<SiteUser, Long> {
    fun findByUsername(username: String): SiteUser
    fun existsByUsername(username: String): Boolean
}