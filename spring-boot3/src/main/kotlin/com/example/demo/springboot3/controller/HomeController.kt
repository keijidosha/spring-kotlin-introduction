package com.example.demo.springboot3.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController {

    @GetMapping("/")
    fun index(): String {
        return "form"
    }

    @PostMapping("/confirm")
    fun confirm(@RequestParam message: String?, model: Model):String {
//        model.addAttribute("message", message)
        message?.let{ model["message"] = message }
        return "confirm"
    }
}