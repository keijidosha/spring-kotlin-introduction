package com.example.demo.springmvc1.controller

import com.example.demo.springmvc1.model.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController {
    @GetMapping("/form")
    private fun readForm(@ModelAttribute user: User): String {
        return "form"
    }

    @PostMapping("/form")
    private fun confirm(@ModelAttribute user: User): String {
        return "confirm"
    }
}