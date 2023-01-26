package com.example.demo.springjpa3.config

import com.example.demo.springjpa3.model.Department
import com.example.demo.springjpa3.repository.DepartmentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(private val repository: DepartmentRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        var department = Department(null, "営業", null)
        repository.save(department)
        repository.save(Department(null, "開発", null))
    }
}