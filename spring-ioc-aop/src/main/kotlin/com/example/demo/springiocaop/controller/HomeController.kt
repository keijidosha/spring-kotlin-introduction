package com.example.demo.springiocaop.controller

import com.example.demo.springiocaop.repository.CoffeeRepository
import lombok.RequiredArgsConstructor
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@RequiredArgsConstructor
@Controller
class HomeController(private val appContext: ApplicationContext) {
    @GetMapping("/")
    fun showList(model: Model): String {
        val repository: CoffeeRepository = appContext.getBean("coffeeRepository") as CoffeeRepository
        model.addAttribute("toString", this.toString())
        model.addAttribute("allCoffee", repository.findAll())
        return "index"
    }
}