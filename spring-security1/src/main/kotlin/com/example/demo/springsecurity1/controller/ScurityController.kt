package com.example.demo.springsecurity1.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ScurityController {

    @GetMapping("/")
    fun success(): String {
        return "success"
    }
}