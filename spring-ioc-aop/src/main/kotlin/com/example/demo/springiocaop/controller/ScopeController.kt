package com.example.demo.springiocaop.controller

import com.example.demo.springiocaop.repository.CoffeeRepository
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Scope("request")
@Controller
class ScopeController(private val repository: CoffeeRepository) {
    @GetMapping("/scope")
    fun showList(model: Model): String {
        model.addAttribute("toString", this.toString())
        model.addAttribute("allCoffee", repository.findAll())
        return "index"
    }
}