package com.example.demo.springiocaop

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class SpringIocAopApplication(private val appContext: ApplicationContext): CommandLineRunner {
	companion object {
		private val log = LoggerFactory.getLogger(SpringIocAopApplication::class.java)
	}

	override fun run(vararg args: String?) {
		val allBeanName = appContext.beanDefinitionNames
		allBeanName.forEach { beanName ->
			log.info("Bean名: {}", beanName)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<SpringIocAopApplication>(*args)
}
