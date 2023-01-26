package com.example.demo.springjpa2.config

import com.example.demo.springjpa2.model.Comment
import com.example.demo.springjpa2.repository.CommentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(val repository: CommentRepository): CommandLineRunner {

    override fun run(vararg args: String?) {
        var comment = Comment()
        comment.content = "こんにちは"
        repository.save(comment)

        comment = Comment()
        comment.content = "テストコメント"
        repository.save(comment)
    }
}