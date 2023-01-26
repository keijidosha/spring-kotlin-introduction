package com.example.demo.springjpa3.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @NotBlank
    @Size(max = 40)
    var name: String? = null
    @ManyToOne
    var department: Department? = null
}
