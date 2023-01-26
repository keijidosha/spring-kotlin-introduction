package com.example.demo.springmvc2.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class Inquiry(
    @field: NotBlank
    @field: Size(max = 6)
    val name: String?,
    @field: NotBlank
    @field: Email
    @field: Size(max = 254)
    val email: String?,
    @field: NotBlank
    @field: Size(max = 500)
    val inquiry: String?
)