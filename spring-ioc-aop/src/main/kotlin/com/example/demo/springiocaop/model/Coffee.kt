package com.example.demo.springiocaop.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Coffee {
    @Id
    @GeneratedValue
    var id: Long? = null
    var name: String? = null
}