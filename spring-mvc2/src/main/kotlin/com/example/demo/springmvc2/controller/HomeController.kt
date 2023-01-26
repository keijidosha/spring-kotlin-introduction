package com.example.demo.springmvc2.controller

import com.example.demo.springmvc2.model.Inquiry
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController {
    @GetMapping("/")
    fun index(@ModelAttribute inquiry: Inquiry): String {
        return "index"
    }

    @PostMapping("/")
    fun confirm(@Validated @ModelAttribute inquiry: Inquiry, result: BindingResult): String {
        if(result.hasErrors()) {
            return "index"
        }
        return "confirm"
    }
}