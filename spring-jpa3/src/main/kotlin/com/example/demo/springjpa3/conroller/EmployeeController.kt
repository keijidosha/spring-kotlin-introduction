package com.example.demo.springjpa3.conroller

import com.example.demo.springjpa3.model.Employee
import com.example.demo.springjpa3.repository.EmployeeRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class EmployeeController(private val repository: EmployeeRepository) {
    @GetMapping("/")
    fun showList(model: Model): String {
        model["employees"] = repository.findAll()
        return "index"
    }

    @GetMapping("/add")
    fun addEmployee(@ModelAttribute employee: Employee): String {
        return "form"
    }

    @PostMapping("/process")
    fun process(@Validated @ModelAttribute employee: Employee, result: BindingResult): String {
        if(result.hasErrors()) {
            return "form"
        }

        repository.save(employee)
        return "redirect:/"
    }

    @GetMapping("/edit/{id}")
    fun editEmployee(@PathVariable id: Long, model: Model): String {
        model["employee"] = repository.findById(id)
        return "form"
    }

    fun deleteEmployee(@PathVariable id: Long): String {
        repository.deleteById(id)
        return "redirect:/"
    }
}