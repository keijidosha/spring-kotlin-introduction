package com.example.demo.springjpa3.repository

import com.example.demo.springjpa3.model.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository: JpaRepository<Department, Long> {
}