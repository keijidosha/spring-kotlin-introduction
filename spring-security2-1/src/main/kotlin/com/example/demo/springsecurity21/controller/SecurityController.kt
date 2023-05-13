package com.example.demo.springsecurity21.controller

import com.example.demo.springsecurity21.model.SiteUser
import com.example.demo.springsecurity21.repository.SiteUserRepository
import com.example.demo.springsecurity21.util.Authority
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SecurityController(
    private val userRepository: SiteUserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/")
    fun showList(loginUser: Authentication, model: Model): String {
        model.addAttribute("username", loginUser.name)
        model.addAttribute("authority", loginUser.authorities)
        return "user"
    }

    @GetMapping("/admin/list")
    fun showAdminList(model: Model): String {
        model.addAttribute("users", userRepository.findAll())
        return "list"
    }

    @GetMapping("/register")
    fun register(@ModelAttribute("user") user: SiteUser): String {
        return "register"
    }

    @PostMapping("/register")
    fun process(@Validated @ModelAttribute("user") user: SiteUser, result: BindingResult): String {
        if(result.hasErrors()) {
            return "register"
        }

        user.password = passwordEncoder.encode(user.password)
        if(user.admin) {
            user.authority = Authority.ADMIN
        }else{
            user.authority = Authority.USER
        }
        userRepository.save(user)

        return "redirect:/login?register"
    }
}