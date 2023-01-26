package com.example.demo.springjpa2.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/*
@Entity
class Comment {
    @Id
    @GeneratedValue
    var id: Long? = null

    @NotBlank
    @Size(max = 40)
    var content: String? = null
}
*/

@Entity
data class Comment(
    @field: Id
    @field: GeneratedValue
    var id: Long?,
    @field: NotBlank
    @field: Size(max = 40)
    var content: String?
) {
    constructor(): this(null, null)
}
