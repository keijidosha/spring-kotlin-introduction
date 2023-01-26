package com.example.demo.springjpa3.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
data class Department(
    @field: Id
    @field: GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @field: NotBlank
    @field: Size(max = 40)
    val name: String?,
    @field: OneToMany(mappedBy = "department")
    val employees: List<Employee>?,
)
