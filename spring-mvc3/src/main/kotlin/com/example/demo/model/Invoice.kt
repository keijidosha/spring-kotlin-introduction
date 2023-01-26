package com.example.demo.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO
import org.springframework.format.annotation.NumberFormat
import java.math.BigDecimal
import java.time.LocalDate

data class Invoice(
    @field: NotBlank
    @field: Size(max = 60)
    val name: String?,
    @field: NotBlank
    @field: Size(max = 254)
    val address: String?,
    @field: NotBlank
    @field: Pattern(regexp = "[0-9-]*")
    val phoneNumber: String?,
    @field: NotNull
    @field: Min(1000)
    @field: NumberFormat(pattern = "#,###")
    val price: BigDecimal?,
    @field: NotNull
    @field: DateTimeFormat(iso = ISO.DATE)
    val paymentDeadline: LocalDate?,
)