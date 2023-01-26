package com.example.demo.springjpa2.repository

import com.example.demo.springjpa2.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}