package com.example.demo.springsecurity21

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class SpringSecurity21Application(private val appContext: ApplicationContext)

fun main(args: Array<String>) {
	runApplication<SpringSecurity21Application>(*args)
}
