package com.example.demo.controller

import com.example.demo.model.Invoice
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController {
    @GetMapping("/")
    fun index(@ModelAttribute invoice: Invoice): String {
        return "index"
    }

    @PostMapping("/")
    fun confirm(@Validated @ModelAttribute invoice: Invoice, result: BindingResult): String {
        if(result.hasErrors()) {
            return "index"
        }
        return "confirm"
    }
}