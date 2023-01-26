package com.example.springboot2.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController {

    @GetMapping("/")
    fun greting(): String {
        return "hello"
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(required = false) message: String?, model: Model): String {
        model.addAttribute("sample", message)
        return "hello"
    }
}