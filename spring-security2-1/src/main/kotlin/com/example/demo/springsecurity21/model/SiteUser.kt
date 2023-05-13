package com.example.demo.springsecurity21.model

import com.example.demo.springsecurity21.util.Authority
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Size(min = 2, max = 20)
    var username: String? = null

    @Size(min = 4, max = 255)
    var password: String? = null

    @NotBlank
    @Email
    var email: String? = null

    var gender: Int = 0
    var admin: Boolean = false
    var authority: Authority? = null
}