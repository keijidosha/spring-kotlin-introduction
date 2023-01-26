package com.example.springboot1.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloController {
    @RequestMapping("/")
    fun index(): String {
        return "hello"
    }
}