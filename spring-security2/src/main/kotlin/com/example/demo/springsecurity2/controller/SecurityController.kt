package com.example.demo.springsecurity2.controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SecurityController {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/")
    fun showList(loginUser: Authentication, model: Model): String {
        model.addAttribute("username", loginUser.name)
        model.addAttribute("role", loginUser.authorities)
        return "user"
    }
}