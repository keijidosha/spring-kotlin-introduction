package com.example.demo.springjpa2.controller

import com.example.demo.springjpa2.model.Comment
import com.example.demo.springjpa2.repository.CommentRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CommentController {
    private lateinit var repository: CommentRepository

    constructor(repository: CommentRepository) {
        this.repository = repository
    }

    @GetMapping("/")
    fun getAllComments(@ModelAttribute comment: Comment, model: Model): String {
        model.addAttribute("comments", repository.findAll())
        return "list"
    }

    @PostMapping("/add")
    fun addComment(@Validated @ModelAttribute comment: Comment, result: BindingResult, model: Model): String {
        model["comments"] = repository.findAll()
        if(result.hasErrors()) {
            return "list"
        }

        repository.save(comment)

        return "redirect:/"
    }
}