package com.example.demo.springjpa1.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Book(
    @field: Id
    @field: GeneratedValue
    val id: Long?,
    val title: String?,
    val detail: String?,
)
