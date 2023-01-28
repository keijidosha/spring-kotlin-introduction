package com.example.demo.springiocaop.repository

import com.example.demo.springiocaop.model.Coffee
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeRepository: JpaRepository<Coffee, Long>